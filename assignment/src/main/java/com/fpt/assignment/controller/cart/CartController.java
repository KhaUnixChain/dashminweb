package com.fpt.assignment.controller.cart;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.fpt.assignment.model.CartItem;
import com.fpt.assignment.model.Customer;
import com.fpt.assignment.model.Invoice;
import com.fpt.assignment.model.InvoiceDetails;
import com.fpt.assignment.model.MailInfo;
import com.fpt.assignment.repository.InvoiceDAO;
import com.fpt.assignment.repository.InvoiceDetailDAO;
import com.fpt.assignment.service.MailServiceInterface;
import com.fpt.assignment.serviceImpl.CartProductService;
import com.fpt.assignment.serviceImpl.CookieService;
import com.fpt.assignment.serviceImpl.EmployeeService;
import com.fpt.assignment.utils.SaveHelperUtils;

@Controller
public class CartController {
    @Autowired
    CartProductService carts;
    @Autowired
    MailServiceInterface mailer;
    @Autowired
    CookieService cookie;
    @Autowired
    EmployeeService emDao;
    @Autowired
    InvoiceDAO invoiceDAO;
    @Autowired
    InvoiceDetailDAO invoiceDetailDAO;

    /**
     * this is add item
     * @param id
     * @return
     */
    @RequestMapping("cart/add")
    public RedirectView addItem(@RequestParam("id") String id) {
        if (SaveHelperUtils.customer == null) {
            return new RedirectView("/login");
        }
        /** this is cart item found in database */
        CartItem cartItem1 = carts.findCartItemDB(id);

        /** check carts map contain this item of db */
        if (carts.getCartItemId(id) == null) {
            carts.add(cartItem1);
        }
        else {
            CartItem cartItem2 = carts.getCartItemId(id);
            int qty = cartItem2.getQty() + 1;
            carts.update(cartItem2, qty);
        }
        System.out.println("number product: " + carts.getCount());
        System.out.println(carts.getCartItemId(id).getId() + " --- " + carts.getCartItemId(id).getQty());
        System.out.println("========================================");
        return new RedirectView("/");
    }


    /**
     * this is update quantity when user buy
     * @param id
     * @param qty
     * @return
     */
    @RequestMapping("cart/update")
    public String updateItem(@RequestParam("id") String id,  @RequestParam("action") String action) {
        CartItem cartItem = carts.getCartItemId(id);
        if (action.equalsIgnoreCase("minus")) {
            int qty = cartItem.getQty() - 1;
            if (qty < 1) {
                qty = 1;
            }
            cartItem.setQty(qty);
        }
        else if (action.equalsIgnoreCase("plus")) {
            int qty = cartItem.getQty() + 1;
            cartItem.setQty(qty);
        }
        return "redirect:/cart";
    }


    /**
     * this is remove items in map
     * @param id
     * @return
     */
    @RequestMapping("cart/remove")
    public String removeItem(@RequestParam("id") String id) {
        CartItem cartItem = carts.getCartItemId(id);
        carts.remove(cartItem);
        return "redirect:/cart";
    }


    /**
     * delete all of items in map
     * @return
     */
    @RequestMapping("cart/clear")
    public String clearItem() {
        carts.clear();
        return "redirect:/cart";
    }



    @RequestMapping("cart/bill")
    public String bill(Model model) {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        Customer customer = SaveHelperUtils.customer;
        model.addAttribute("now", date);
        model.addAttribute("user", customer);
        model.addAttribute("carts", carts);
        model.addAttribute("atm", "050078185489");
        return "bill";
    }



    /**
     * this is payment
     * @return
     */
    @RequestMapping("cart/payment")
    public String pay(Model model) {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        Customer customer = SaveHelperUtils.customer;
        model.addAttribute("now", date);
        model.addAttribute("user", customer);
        model.addAttribute("carts", carts);
        model.addAttribute("atm", "050078185489");

        Invoice invoice = new Invoice();
        invoice.setCustomer(customer);
        invoice.setEmployee(emDao.findById("PD05178"));
        invoice.setPurchaseDate(java.sql.Date.valueOf(LocalDate.now()));
        invoice.setAmount(carts.getAmount());
        invoiceDAO.save(invoice);

        for (CartItem cartItem : carts.getCarts()) {
            InvoiceDetails invoiceDetails = new InvoiceDetails();
            invoiceDetails.setInvoice(invoice);
            invoiceDetails.setNote("This is " + cartItem.getProduct().getName());
            invoiceDetails.setProduct(cartItem.getProduct());
            invoiceDetails.setQuantity(cartItem.getQty());
            invoiceDetailDAO.save(invoiceDetails);
        }
        
		try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/cart/bill"))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            MailInfo mailInfo = new MailInfo(customer.getEmail().trim(), "Invoice Dashmin " + customer.getEmail(), response.body());
            mailer.send(mailInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
		carts.clear();
        return "redirect:/";
    }
}

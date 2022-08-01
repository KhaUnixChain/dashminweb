package com.fpt.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpt.assignment.data.DB;
import com.fpt.assignment.model.Customer;
import com.fpt.assignment.repository.InvoiceDetailDAO;
import com.fpt.assignment.serviceImpl.CartProductService;   
import com.fpt.assignment.serviceImpl.CategoryService;
import com.fpt.assignment.serviceImpl.CookieService;
import com.fpt.assignment.utils.SaveHelperUtils;

@Controller
public class HomeController {
    @Autowired
    CookieService cookie;
    @Autowired
    CategoryService categoryService;
    @Autowired
    InvoiceDetailDAO inDeDao;
    @Autowired
    DB db;
    @Autowired
    CartProductService cart;

    /**
     * http://localhost:8080/
     * This is index page localhost first not login
     * @return index page jsp
     */
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("dbs", db.getDBProducts().values());
        model.addAttribute("qty", cart.getCount());
        return "home";
    }

    /**
     * http://localhost:8080/admin
     * This is page of manerger when he change path for himself
     * @return admin page jsp
     */
    @RequestMapping("/admin")
    public String admin(Model model) {
        String id = cookie.getValue("employee_id");
        String pw = cookie.getValue("employee_pw");
        String re = cookie.getValue("remember");
        model.addAttribute("employee_id", id == null ? "" : id);
        model.addAttribute("employee_pw", pw == null ? "" : pw);
        model.addAttribute("remember", re == null ? "" : re);
        return "admin";
    }

    /**
     * http://localhost:8080/login
     * user click login page
     * @return
     */
    @RequestMapping("/portfolio")
    public String portfolio() {
        return "portfolio-details";
    }

    /**
     * http://localhost:8080/login
     * user click login page
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "user/account/login";
    }

    /**
     * user click forgot in login page
     * @return
     */
    @RequestMapping("/forgot")
    public String forgot() {
        return "user/account/forgot"; // in form have action /verify (AdminController)
    }

    /**
     * user click forgot in login page
     * @return
     */
    @RequestMapping("/change")
    public String change() {
        return "user/account/change";
    }

    /**
     * user click signIn in login page
     * @return
     */
    @RequestMapping("/signup")
    public String signin() {
        return "user/account/signup";
    }

    /**
     * this is controller for order
     * @return
     */
    @RequestMapping("/history")
    public String order(Model model) {
        model.addAttribute("invoicesDetails", inDeDao.findAllCustomer(SaveHelperUtils.customer));
        return "history";
    }

    /**
     * this is controller for cart 
     * @param model
     * @return
     */
    @RequestMapping("/cart")
    public String cart(Model model) {
        if (cart.getCount() == 0) {
            return "nothing";
        }
        model.addAttribute("carts", cart);
        cookie.remove("atm");
        return "cart";
    }

    /**
     * this is model
     * @return
     */
    @ModelAttribute("account")
    public String logged() {
        Customer customer = SaveHelperUtils.customer;
        return customer == null ? "Login" : customer.getEmail();
    }
}

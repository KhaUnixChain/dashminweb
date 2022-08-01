package com.fpt.assignment.controller.dashboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fpt.assignment.model.Category;
import com.fpt.assignment.model.Customer;
import com.fpt.assignment.model.Employee;
import com.fpt.assignment.model.Product;
import com.fpt.assignment.model.ReportEmployee;
import com.fpt.assignment.repository.EmployeeDAO;
import com.fpt.assignment.repository.InvoiceDAO;
import com.fpt.assignment.repository.InvoiceDetailDAO;
import com.fpt.assignment.serviceImpl.*;
import com.fpt.assignment.utils.SaveHelperUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardController {
    @Autowired
    ProductService pDao;
    @Autowired
    CategoryService cDao;
    @Autowired
    CustomerService cuDao;
    @Autowired
    EmployeeDAO emDao;
    @Autowired
    InvoiceDAO inDAO;
    @Autowired
    InvoiceDetailDAO indetailDAO;
    @Autowired
    SessionService session;

    /**
     * This is index of manager view and depend on page to convert page
     * @return
     */
    @RequestMapping("dashboard/{page}")
    public String dashboard(
        @PathVariable("page") String p, 
        @ModelAttribute("itemPr") Product product, 
        @ModelAttribute("itemCa") Category category, 
        @ModelAttribute("reportToYear") List<ReportEmployee> reportToYear,
        @ModelAttribute("reportYearAgo") List<ReportEmployee> reportYearAgo,
        Model model) 
    {
        if (SaveHelperUtils.employee == null)
            return "admin";

        int saleToYear = 0;
        int invoice = 0;
        int saleLastYear = 0;
        for (ReportEmployee report : reportToYear) {
            saleToYear +=  report.getSum();
            invoice += report.getCount();
        }

        for (ReportEmployee report : reportYearAgo) {
            saleLastYear += report.getSum();
        }

        model.addAttribute("saleToYear", saleToYear);
        model.addAttribute("invoices", invoice);
        model.addAttribute("saleLastYear", saleLastYear);
        model.addAttribute("invoices_list", inDAO.findAmountMax());
        model.addAttribute("top_product", indetailDAO.getTop5ProductBest());
        model.addAttribute("percent", (saleToYear-saleLastYear)*100/(saleLastYear*2));
        return "dashboard/" + p;
    }


    // ------------------------------------------------------------
    @ModelAttribute("categories_map")
    public Map<Integer, String> getCategoriesMap() 
    {
        List<Category> list = cDao.findAll();
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (Category category : list) {
            map.put(category.getId(), category.getType());
        }
        return map;
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return cDao.findAll();
    }

    @ModelAttribute("products")
    public List<Product> getProducts() {
        return pDao.findAll();
    }

    @ModelAttribute("customers")
    public Page<Customer> getCustomer(@RequestParam("keyword") Optional<String> keyOptional, @RequestParam("p") Optional<Integer> p) 
    {
        Pageable pageable = PageRequest.of(p.orElse(0), 12);
        Page<Customer> page = cuDao.findAll(pageable);
        return page;
    }

    @ModelAttribute("employees")
    public Page<Employee> getEmployee(
            @RequestParam("p") Optional<Integer> p) 
    {
        Pageable pageable = PageRequest.of(p.orElse(0), 10);
        Page<Employee> page = emDao.findAll(pageable);
        return page;
    }

    @ModelAttribute("employee")
    public Employee account() {
        return SaveHelperUtils.employee;
    }

    @ModelAttribute("reportToYear")
    public List<ReportEmployee> getReportToYear() {
        return inDAO.getReportToYear();
    }

    @ModelAttribute("reportYearAgo")
    public List<ReportEmployee> getReportYearAgo() {
        return inDAO.getReportYearAgo();
    }
}

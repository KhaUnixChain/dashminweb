package com.fpt.assignment.controller.login;

import com.fpt.assignment.model.Customer;
import com.fpt.assignment.model.Employee;
import com.fpt.assignment.serviceImpl.*;
import com.fpt.assignment.utils.SaveHelperUtils;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    EmployeeService emDao;
    @Autowired
    CustomerService cuDao;
    @Autowired
    CookieService cookie;
    @Autowired
    ParamService param;
    @Autowired
    SessionService session;

    /**
     * http://localhost:8080/admin/login
     * @param id
     * @param password
     * @return
     */
    @PostMapping("/admin/login")
    public String login(@RequestParam("id") String id, @RequestParam("password") String password, Model model) {
        Employee employee = emDao.findAccount(id, password);
        if (employee == null) {
            return "500";
        }
        else {
            String click = param.getString("remember", "null");
            if (employee.getRole()) {
                if (click.equalsIgnoreCase("on")) { 
                    cookie.add("employee_id", employee.getId(), 12);
                    cookie.add("employee_pw", employee.getPassword(), 12);
                    cookie.add("remember", "checked", 12);
                }
                session.set("id", employee.getId());
                SaveHelperUtils.employee = employee;
                model.addAttribute("employee", SaveHelperUtils.employee);
            }
            else {
                return "500";
            }
        }
        return "redirect:/dashboard/report";
    }

    
    @RequestMapping("/admin/logout")
    public String logout() {
        SaveHelperUtils.employee=null;
        session.remove("id");
        return "redirect:/";
    }




    /**
     * this is function which to user login their account
     * @param model
     * @param email
     * @param pass
     * @return
     */
    @RequestMapping("/user/login")
    public String signIn(@ModelAttribute("account") Customer customer, @RequestParam("email") String email, @RequestParam("pass") String pass) {
        customer = cuDao.findByEmailAndPassword(email, pass);
        SaveHelperUtils.customer = customer;
        return "redirect:/";
    }

    @RequestMapping("/user/logout")
    public String logout(@ModelAttribute("account") Customer customer) {
        SaveHelperUtils.customer = null;
        return "redirect:/";
    }

    @RequestMapping("/user/signup")
    public String signup(@RequestParam("email") String email, @RequestParam("pass") String password, @RequestParam("name") String name, @RequestParam("phone") String phone) {
        Customer customer = new Customer(name, email, phone, password);
        if (cuDao.findByEmailAndPassword(email, password) == null) {
            cuDao.save(customer);
        }
        return "redirect:/";
    }

    @RequestMapping("user/forgot")
    public String forgot(@RequestParam("email") String email) {
        return "redirect:/forgot";  // go to homecontroller to show page forgot
    }


    /**
     * 
     * @param user
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     * @throws MessagingException
     */
    @PostMapping("/process_register")
    public String processRegister(Customer user, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        cuDao.register(user, getSiteURL(request));       
        return "register_success";
    }
     
    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }  


    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code) {
        if (cuDao.verify(code)) {
            return "redirect:/user/login";
        } else {
            return "500";
        }
    }
}

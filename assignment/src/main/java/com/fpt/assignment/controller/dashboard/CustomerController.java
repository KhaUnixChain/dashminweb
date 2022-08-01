package com.fpt.assignment.controller.dashboard;

import com.fpt.assignment.model.Customer;
import com.fpt.assignment.serviceImpl.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
    @Autowired
    CustomerService cuDao;
    @Autowired
    SessionService session;

    @RequestMapping("dashboard/customer")
    public String search(@RequestParam("keyword") Optional<String> keyOptional, @RequestParam("p") Optional<Integer> p, Model model){
        String kword = keyOptional.orElse(session.get("keywords")==null ? "" : session.get("keywords"));
        session.set("keywords", kword);
        Pageable pageable = PageRequest.of(p.orElse(0), 12);
        Page<Customer> page = cuDao.findPhoneAndName("%"+kword+"%", pageable);
        model.addAttribute("customers", page);
        return "dashboard/customer";
    }
}

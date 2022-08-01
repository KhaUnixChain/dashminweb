package com.fpt.assignment.controller.dashboard;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpt.assignment.model.Employee;
import com.fpt.assignment.serviceImpl.EmployeeService;
import com.fpt.assignment.serviceImpl.SessionService;
import com.fpt.assignment.utils.SaveHelperUtils;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService emDao;
    @Autowired
    SessionService session;

    @RequestMapping("dashboard/search")
    public String search(
            @RequestParam("keyId") Optional<String> keyId,
            @RequestParam("keyRol") Optional<Boolean> role,
            @RequestParam("p") Optional<Integer> p,
            Model model)
    {
        String  id_email = keyId.orElse(session.get("keyId") == null ? "PD" : session.get("keyId"));

        session.set("keyId", id_email);
        session.set("keyRol", String.valueOf(role.get()));

        Pageable pageable = PageRequest.of(p.orElse(0), 10);
        Page<Employee> page = emDao.findByIdAndRole("%"+id_email+"%", role.get(), pageable);
        model.addAttribute("employees", page);
        model.addAttribute("employee", SaveHelperUtils.employee);
        return "dashboard/employee";
    }
}

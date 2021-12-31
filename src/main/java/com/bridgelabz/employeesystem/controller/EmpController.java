package com.bridgelabz.employeesystem.controller;

import com.bridgelabz.employeesystem.entity.Employee;
import com.bridgelabz.employeesystem.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmpController {
    @Autowired
    private EmpService service;

    @GetMapping
    public String home(Model m ){
    List<Employee> emp = service.getAllEmp();
    m.addAttribute("emp", emp);
        return "index";
    }
    @GetMapping("/addemp")
    public String addEmpForm(){
        return "add_emp";
    }
    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee e, HttpSession session){
        System.out.println(e);
        service.addEmp(e);
       session.setAttribute("msg","Employe added successfully....");
        return "redirect:/";

    }
    @GetMapping("/edit/{id}")
    public  String edit(@PathVariable int id, Model m){
        Employee e=service.getById(id);
        m.addAttribute("emp", e);
        return "edit";

    }
    @PostMapping("/update")
    public String update(@ModelAttribute Employee e, HttpSession session){
    service.addEmp(e);
    session.setAttribute("msg", "Emp Data Update successfully....");
    return "redirect:/";
    }
}

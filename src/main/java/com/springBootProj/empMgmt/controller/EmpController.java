package com.springBootProj.empMgmt.controller;

import com.springBootProj.empMgmt.entity.Emp;
import com.springBootProj.empMgmt.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.geom.GeneralPath;
import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping()
    public String home(Model m) {

        List<Emp> emp = empService.getAllEmployee();
        m.addAttribute("emp", emp);
        return "index";
    }

    @GetMapping("/addemp")
    public String addEmpForm() {
        return "add_emp";
    }

    @PostMapping("/register")
    public String empRegister(@ModelAttribute Emp e, RedirectAttributes redirectAttributes) {
        empService.addEmp(e);

        redirectAttributes.addFlashAttribute("msg", "Employee added successfully!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m) {
        Emp e = empService.getEmpById(id);
        m.addAttribute("emp", e);

        return "edit";
    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Emp e, RedirectAttributes redirectAttributes) {
        empService.addEmp(e);

        redirectAttributes.addFlashAttribute("msg", "Employee updated successfully!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id, RedirectAttributes redirectAttributes) {
        empService.deleteEmp(id);

        redirectAttributes.addFlashAttribute("msg", "Employee deleted successfully!");
        return "redirect:/";
    }
}

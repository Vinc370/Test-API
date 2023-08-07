package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.Entity.Department;
import com.example.demo.Services.DepartmentService;

@Controller
@RequestMapping("department")
public class DepartmentController {
    
    @Autowired
    private DepartmentService<Department> departmentService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("department", departmentService.getAll());
        return "department/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String form(Model model, @PathVariable(required = false) Integer id){
        if(id != null){
            model.addAttribute("department", departmentService.Get(id));
            model.addAttribute("departments", departmentService.getAll());
        }
        else{
            model.addAttribute("department", new Department());
            model.addAttribute("departments", departmentService.getAll());
        }
        
        return "department/form";
    }

    @PostMapping("save")
    public String submit(Department department){
        Boolean result = departmentService.Insert(department);
        if (result){
            return "redirect:/department";
        }
        else{
            return "department/form";
        }
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id){
        departmentService.Delete(id);
        return "redirect:/department";
    }
}

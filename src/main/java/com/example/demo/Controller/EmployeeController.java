package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.Entity.Employee;
import com.example.demo.Services.EmployeeService;

@Controller
@RequestMapping("employee") // https://localhost:8088/employee
public class EmployeeController {
    
    @Autowired
    private EmployeeService<Employee> employeeService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("employee", employeeService.getAll());
        return "employee/index";
    }

    @GetMapping(value = {"form", "form/{id}"}) // https://localhost:8088/form
    public String form(Model model, @PathVariable(required = false) Integer id){
        if(id != null){
            model.addAttribute("employee", employeeService.Get(id));
            model.addAttribute("employees", employeeService.getAll());
        }
        else{
            model.addAttribute("employee", new Employee());
            model.addAttribute("employees", employeeService.getAll());
        }
        
        return "employee/form";
    }
    
    @PostMapping("save")
    public String submit(Employee employee){
        Boolean result = employeeService.Insert(employee);
        if (result){
            return "redirect:/employee";
        }
        else{
            return "employee/form";
        }
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id){
        employeeService.Delete(id);
        return "redirect:/employee";
    }
}

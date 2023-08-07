package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.Handler.Response;
import com.example.demo.Services.EmployeeService;

@RestController
@RequestMapping("api")
public class EmployeeRestController {
    @Autowired
    private EmployeeService<Employee> employeeService;

    @GetMapping("employee")
    public ResponseEntity<Object> getAll(){
        //return employeeService.getAll();
        return Response.generate(HttpStatus.OK, "data retrieved", employeeService.getAll());
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id){
        //return employeeService.Get(id);
        return Response.generate(HttpStatus.OK, "data retrieved", employeeService.Get(id));
    }

    @PostMapping("employee")
    public ResponseEntity<Object> post(@RequestBody Employee employee){
        employeeService.Insert(employee);
        return Response.generate(HttpStatus.OK, "data retrieved");
    }

    @DeleteMapping("employee/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id){
        employeeService.Delete(id);
        return Response.generate(HttpStatus.OK, "data retrieved");
    }
}

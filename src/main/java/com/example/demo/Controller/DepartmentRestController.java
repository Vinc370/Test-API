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

import com.example.demo.Entity.Department;
import com.example.demo.Handler.Response;
import com.example.demo.Services.DepartmentService;

@RestController
@RequestMapping("department")
public class DepartmentRestController {
    @Autowired
    private DepartmentService<Department> departmentService;

    @GetMapping("Department")
    public ResponseEntity<Object> getAll(){
        //return departmentService.getAll();
        return Response.generate(HttpStatus.OK, "data retrieved", departmentService.getAll());
    }

    @GetMapping("Department/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id){
        //return departmentService.Get(id);
        return Response.generate(HttpStatus.OK, "data retrieved", departmentService.Get(id));
    }

    @PostMapping("Department")
    public ResponseEntity<Object> post(@RequestBody Department department){
        departmentService.Insert(department);
        return Response.generate(HttpStatus.OK, "data retrieved");
    }

    @DeleteMapping("Department/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id){
        departmentService.Delete(id);
        return Response.generate(HttpStatus.OK, "data retrieved");
    }
}

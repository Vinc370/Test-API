package com.example.demo.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepository;

@Service
public class EmployeeImplement implements EmployeeService<com.example.demo.Entity.Employee>{

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public Boolean Insert(Employee model) {
        employeeRepository.save(model);
        return employeeRepository.findById(model.getEmployeeID()).isPresent();
    }

    @Override
    public Boolean Update(Employee model) {
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public Boolean Delete(int model) {
        employeeRepository.deleteById(model);
        return !employeeRepository.findById(model).isPresent();    
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee Get(int model) {
        return employeeRepository.findById(model).get();
    }

    @Override
    public Integer findIdbyEmail(String email) {
        return employeeRepository.findIdbyEmail(email);
    }
    
}

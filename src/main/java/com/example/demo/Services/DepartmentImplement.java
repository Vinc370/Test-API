package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Department;
import com.example.demo.Repository.DepartmentRepository;

@Service
public class DepartmentImplement implements DepartmentService<com.example.demo.Entity.Department>{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Boolean Insert(Department model) {
        departmentRepository.save(model);
        return departmentRepository.findById(model.getDepartmentID()).isPresent();
    }

    @Override
    public Boolean Update(Department model) {
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public Boolean Delete(int model) {
        departmentRepository.deleteById(model);
        return !departmentRepository.findById(model).isPresent();
    }

    @Override
    public Department Get(int model) {
        return departmentRepository.findById(model).get();
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
    
}

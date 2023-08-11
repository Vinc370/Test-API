package com.example.demo.Services;

import com.example.demo.Services.Generic.GenericServices;

public interface EmployeeService<T> extends GenericServices<T> {

    public Integer findIdbyEmail(String email);
    
}

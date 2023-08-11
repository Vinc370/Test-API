package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.RegisterRequest;
import com.example.demo.Entity.Employee;
import com.example.demo.Entity.User;

@Service
public class AccountImplement implements AccountService{

    @Autowired
    private UserService<User> userService;

    @Autowired
    private EmployeeService<Employee> employeeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Boolean register(RegisterRequest registerRequest) {
        Employee employee = new Employee();
        employee.setEmployeeID(registerRequest.getId());
        employee.setEmail(registerRequest.getEmail());
        employee.setFullName(registerRequest.getName());

        Boolean resultEmployee = employeeService.Insert(employee);

        if (resultEmployee){
            Integer employee_id = employeeService.findIdbyEmail(registerRequest.getEmail());
            User user = new User();
            user.setUserID(employee_id);
            user.setEmail(registerRequest.getEmail());
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

            Boolean resultUser = userService.Insert(user);
            return resultUser;
        }
        return resultEmployee;
    }
    
}

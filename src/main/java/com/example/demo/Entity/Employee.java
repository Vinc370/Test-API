package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_m_employee")
public class Employee {
    @Id
    private int employee_id;
    private String fullname;
    private String email;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department Department;

    public Employee(){
        
    }

    public Employee(int employee_id, Department department_id, String fullname){
        setEmployeeID(employee_id);
        setDepartment(department_id);
        setFullName(fullname);
    }

    public int getEmployeeID() {
        return employee_id;
    }
    public void setEmployeeID(int employee_id) {
        this.employee_id = employee_id;
    }
    
    public Department getDepartment() {
        return Department;
    }

    public void setDepartment(Department Department) {
        this.Department = Department;
    }
    
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public String getFullName() {
        return fullname;
    }
    public void setFullName(String fullname) {
        this.fullname = fullname;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

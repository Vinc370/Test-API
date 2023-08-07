package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_m_department")
public class Department {
    @Id
    private int department_id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region Region;

    public Department(){
        
    }

    public Department(int department_id, Region region_id, String name){
        setDepartmentID(department_id);
        setRegion(region_id);
        setName(name);
    }

    public int getDepartmentID() {
        return department_id;
    }
    public void setDepartmentID(int department_id) {
        this.department_id = department_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Region getRegion() {
        return Region;
    }
    public void setRegion(Region Region) {
        this.Region = Region;
    }

}

package com.example.demo.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_m_role")
public class Role {
    @Id
    private int role_id;
    private String name;
    
    @OneToMany(mappedBy = "role")
    private List<User> user;

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public int getRoleID() {
        return role_id;
    }
    public void setRoleID(int role_id) {
        this.role_id = role_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

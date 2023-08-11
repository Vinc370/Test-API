package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserImplement implements UserService<User>{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean Insert(User model) {
        userRepository.save(model);
        return userRepository.findById(model.getUserID()).isPresent();
    }

    @Override
    public Boolean Update(User model) {
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public Boolean Delete(int model) {
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }

    @Override
    public User Get(int model) {
        throw new UnsupportedOperationException("Unimplemented method 'Get'");
    }

    @Override
    public List<User> getAll() {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    
}

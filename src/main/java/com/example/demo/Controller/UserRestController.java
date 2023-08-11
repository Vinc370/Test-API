package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.LoginRequest;
import com.example.demo.DTO.RegisterRequest;
import com.example.demo.Handler.Response;
import com.example.demo.Services.AccountService;

@RestController 
@RequestMapping("api")
public class UserRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AccountService accountService;

    @GetMapping("user/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest login){
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        if(authentication.isAuthenticated()){
            return Response.generate(HttpStatus.OK, "Authenticated");
        }
        else{
            return Response.generate(HttpStatus.OK, "Authentication failed");
        }
    }

    @PostMapping("user/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest registerRequest){
        Boolean result = accountService.register(registerRequest);
        if(result){
            Response.generate(HttpStatus.OK, "Registered");
        }
        return Response.generate(HttpStatus.OK, "Registration failed");
    }

    @PostMapping("user/forgot")
    public String forgotPassword(){
        return " ";
    }

    @PostMapping("user/changePassword")
    public String changePassword(){
        return " ";
    }
}

package com.mycompany.bankservice.controller;

import com.mycompany.bankservice.dto.UserDTO;
import com.mycompany.bankservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO)
    {
        userDTO=userService.register(userDTO);
        ResponseEntity<UserDTO> responseEntity=new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO)
    {
        userDTO=userService.login(userDTO);
        ResponseEntity<UserDTO> responseEntity=new ResponseEntity<>(userDTO, HttpStatus.OK);
        return responseEntity;
    }
}

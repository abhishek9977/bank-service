package com.mycompany.bankservice.service;

import com.mycompany.bankservice.dto.UserDTO;

public interface UserService
{
    UserDTO register(UserDTO userDTO);
    UserDTO login(UserDTO userDTO);

    UserDTO addMoney(UserDTO userDTO);
}

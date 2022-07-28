package com.mycompany.bankservice.service.Impl;

import com.mycompany.bankservice.dto.ErrorDTO;
import com.mycompany.bankservice.dto.UserDTO;
import com.mycompany.bankservice.entity.UserEntity;
import com.mycompany.bankservice.exception.BusinessException;
import com.mycompany.bankservice.repository.UserRepository;
import com.mycompany.bankservice.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO register(UserDTO userDTO)
    {
        UserEntity userEntity=new UserEntity();
        Optional<UserEntity> optionalUserEntity=userRepository.findByEmailId(userDTO.getEmailId());
        if(optionalUserEntity.isEmpty()) {
            BeanUtils.copyProperties(userDTO, userEntity);
            userEntity.setBalance(0.0);
            userEntity = userRepository.save(userEntity);
            BeanUtils.copyProperties(userEntity, userDTO);
        }
        else
        {
            List<ErrorDTO> errorDTOS=new ArrayList<>();
            ErrorDTO errorDTO=new ErrorDTO();
            errorDTO.setErrorCode("INVALID_INFO");
            errorDTO.setMessage("EMAIL_IS_ALREADY_USED");
            errorDTOS.add(errorDTO);

            throw new BusinessException(errorDTOS);
        }
        userDTO.setPassword(null);
        return userDTO;
    }

    @Override
    public UserDTO login(UserDTO userDTO)
    {

       Optional<UserEntity> optionalUserEntity = userRepository.findByEmailIdAndPassword(userDTO.getEmailId(), userDTO.getPassword());
       if(optionalUserEntity.isPresent())
       {
           BeanUtils.copyProperties(optionalUserEntity.get(), userDTO);
       }
       else
       {
           List<ErrorDTO> errorDTOList=new ArrayList<>();
           ErrorDTO errorDTO=new ErrorDTO();
           errorDTO.setErrorCode("INVALID_INFO");
           errorDTO.setMessage("ENTER_CORRECT_INFO");
           errorDTOList.add(errorDTO);

           throw new BusinessException(errorDTOList);

       }
       userDTO.setPassword(null);
       userDTO.setAadharNo(null);
       return userDTO;
    }
}

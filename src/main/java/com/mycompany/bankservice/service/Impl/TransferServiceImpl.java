package com.mycompany.bankservice.service.Impl;

import com.mycompany.bankservice.dto.ErrorDTO;
import com.mycompany.bankservice.dto.TransferDTO;
import com.mycompany.bankservice.entity.TransferEntity;
import com.mycompany.bankservice.entity.UserEntity;
import com.mycompany.bankservice.exception.BusinessException;
import com.mycompany.bankservice.repository.TransferRepository;
import com.mycompany.bankservice.repository.UserRepository;
import com.mycompany.bankservice.service.TransferService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransferServiceImpl implements TransferService
{

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public TransferDTO sendMoney(TransferDTO transferDTO)
    {
        TransferEntity transferEntity=new TransferEntity();
        Optional<UserEntity> optionalUserEntity =userRepository.findByAccountNo(transferDTO.getAccountNo());
        if(optionalUserEntity.get().getBalance()>transferDTO.getAmount())
        {
            BeanUtils.copyProperties(transferDTO,transferEntity);
            optionalUserEntity.get().setBalance(optionalUserEntity.get().getBalance()-transferEntity.getAmount());
            transferEntity.setUserEntity(optionalUserEntity.get());
            transferEntity.setDateAndTime(String.valueOf(LocalDateTime.now()));
            transferEntity=transferRepository.save(transferEntity);
            BeanUtils.copyProperties(transferEntity,transferDTO);
        }
        else
        {
            List<ErrorDTO>  errorDTOS=new ArrayList<>();
            ErrorDTO errorDTO=new ErrorDTO();
            errorDTO.setMessage("INSUFFICIENT_BALANCE");
            errorDTO.setErrorCode("ENTER_RIGHT_AMOUNT");
            errorDTOS.add(errorDTO);
            throw new BusinessException(errorDTOS);
        }
        return transferDTO;
    }
}

package com.mycompany.bankservice.service.Impl;

import com.mycompany.bankservice.dto.BeneficiaryDTO;
import com.mycompany.bankservice.dto.ErrorDTO;
import com.mycompany.bankservice.entity.BeneficiaryEntity;
import com.mycompany.bankservice.entity.UserEntity;
import com.mycompany.bankservice.exception.BusinessException;
import com.mycompany.bankservice.repository.BeneficiaryRepository;
import com.mycompany.bankservice.repository.UserRepository;
import com.mycompany.bankservice.service.BeneficiaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService
{


   @Autowired
   private BeneficiaryRepository beneficiaryRepository;

   @Autowired
   private UserRepository userRepository;
    @Override
    public BeneficiaryDTO addBeneficiary(BeneficiaryDTO beneficiaryDTO)
    {
        BeneficiaryEntity beneficiaryEntity=new BeneficiaryEntity();
       Optional<UserEntity> optEntity= userRepository.findByAccountNo(beneficiaryDTO.getAccountNo());
       if(optEntity.isPresent())
       {

           BeanUtils.copyProperties(beneficiaryDTO,beneficiaryEntity);
           beneficiaryEntity.setUserEntity(optEntity.get());
           beneficiaryEntity=beneficiaryRepository.save(beneficiaryEntity);
           BeanUtils.copyProperties(beneficiaryEntity,beneficiaryDTO);
       }
       else
       {
           List<ErrorDTO> errorDTOList =new ArrayList<>();
           ErrorDTO errorDTO=new ErrorDTO();
           errorDTO.setErrorCode("INVALID_ACC_NO");
           errorDTO.setMessage("ENTER_CORRECT_ACCNO");
           errorDTOList.add(errorDTO);
           throw new BusinessException(errorDTOList);
       }

       return beneficiaryDTO;
    }
}

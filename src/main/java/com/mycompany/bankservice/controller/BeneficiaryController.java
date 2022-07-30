package com.mycompany.bankservice.controller;

import com.mycompany.bankservice.dto.BeneficiaryDTO;
import com.mycompany.bankservice.service.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class BeneficiaryController
{
    @Autowired
    private BeneficiaryService beneficiaryService;

    @PostMapping("/add")
    public ResponseEntity<BeneficiaryDTO> addBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO)
    {

        beneficiaryDTO=beneficiaryService.addBeneficiary(beneficiaryDTO);
        ResponseEntity<BeneficiaryDTO> responseEntity=new ResponseEntity<>(beneficiaryDTO, HttpStatus.CREATED);
        return responseEntity;
    }
}

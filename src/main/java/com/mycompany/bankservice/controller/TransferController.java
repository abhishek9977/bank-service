package com.mycompany.bankservice.controller;

import com.mycompany.bankservice.dto.TransferDTO;
import com.mycompany.bankservice.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3")
public class TransferController
{

    @Autowired
    private TransferService transferService;

    @PostMapping("/send")
    public ResponseEntity<TransferDTO> sendMoney(@RequestBody TransferDTO transferDTO)
    {

        transferDTO=transferService.sendMoney(transferDTO);
        ResponseEntity<TransferDTO> responseEntity=new ResponseEntity<>(transferDTO, HttpStatus.CREATED);
        return responseEntity;
    }
}

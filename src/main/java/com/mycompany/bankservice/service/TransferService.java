package com.mycompany.bankservice.service;

import com.mycompany.bankservice.dto.TransferDTO;

public interface TransferService
{
    TransferDTO sendMoney(TransferDTO transferDTO);
}

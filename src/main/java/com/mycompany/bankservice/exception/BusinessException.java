package com.mycompany.bankservice.exception;

import com.mycompany.bankservice.dto.ErrorDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BusinessException extends RuntimeException
{
    List<ErrorDTO> errorDTOS;

    public  BusinessException()
    {};

    public BusinessException(List<ErrorDTO> errorDTOS)
    {
        this.errorDTOS=errorDTOS;
    }
}

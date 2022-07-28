package com.mycompany.bankservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorDTO
{
    private String errorCode;
    private String message;

}

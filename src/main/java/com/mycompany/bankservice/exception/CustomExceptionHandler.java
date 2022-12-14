package com.mycompany.bankservice.exception;

import com.mycompany.bankservice.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler
{
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorDTO>> handleException(BusinessException bex)
    {
        return new ResponseEntity<List<ErrorDTO>> (bex.getErrorDTOS(),HttpStatus.BAD_REQUEST);
    }
}

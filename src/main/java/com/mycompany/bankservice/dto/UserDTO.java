package com.mycompany.bankservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO
{

    private Long accountNo;
    private String userName;
    private String mobileNo;
    private String aadharNo;
    private String emailId;
    private String password;
    private Double balance;
}

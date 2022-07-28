package com.mycompany.bankservice.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "User_Table")
@NoArgsConstructor
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountNo;
    private String userName;
    private String mobileNo;
    private String aadharNo;
    private String emailId;
    private String password;
    private Double balance;

}

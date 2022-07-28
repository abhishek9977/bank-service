package com.mycompany.bankservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Table(name="Account_Table")
public class AccountEntity
{
    private String name;
    private String accountNo;
    private Double money;
}

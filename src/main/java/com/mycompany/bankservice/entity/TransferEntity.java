package com.mycompany.bankservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="Transfer_Table")
public class TransferEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transferId;
    private String accNo;
    private Double amount;
    private Long accountNo;
    private String dateAndTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Account_Number",nullable = false)
    private UserEntity userEntity;
}


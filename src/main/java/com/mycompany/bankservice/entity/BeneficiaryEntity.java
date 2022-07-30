package com.mycompany.bankservice.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "Beneficiary_Table")
public class BeneficiaryEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String beneficiary;
    private String userName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountNo",nullable = false)
    private UserEntity userEntity;

}

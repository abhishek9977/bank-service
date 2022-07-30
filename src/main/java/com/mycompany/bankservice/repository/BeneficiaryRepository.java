package com.mycompany.bankservice.repository;

import com.mycompany.bankservice.entity.BeneficiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepository extends JpaRepository<BeneficiaryEntity,Long>
{
}

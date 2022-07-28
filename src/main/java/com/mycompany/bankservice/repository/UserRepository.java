package com.mycompany.bankservice.repository;

import com.mycompany.bankservice.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long>
{
    Optional<UserEntity> findByEmailIdAndPassword(String email,String password);
    Optional<UserEntity> findByEmailId(String email);

}

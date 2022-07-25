package com.example.demo.repo;

import com.example.demo.model.Product_Model;
import com.example.demo.model.User_Model;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserReposity extends JpaRepository<User_Model, Long> {
    Boolean existsByEmail(String email);
    @Query(value ="SELECT u FROM User_Model u WHERE u.name LIKE   '%:?1%'  " )
    List<User_Model> findByNameContaining(String keyword);

    @Query(value = "SELECT u FROM User_Model u WHERE u.email =   ':?1'  " )
    Optional<User_Model> findByEmail(String email);

    // Check email existence for sign up
//    @Modifying
//    @Transactional
//    @Query(value = "SELECT count(*) FROM user u WHERE u.email = :email", nativeQuery=true)
//    long existsByEmail(@Param("email") String email);

    // Check email and password for sign in
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM user u WHERE u.email = :email AND u.password = :password", nativeQuery=true)
    List<User_Model> show(@Param("email") String email, @Param("password") String password);
}

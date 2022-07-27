package com.example.demo.repo;

import com.example.demo.model.User_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public interface UserReposity extends JpaRepository<User_Model, Long> {
    Boolean existsByEmail(String email);
    @Query(value ="SELECT u FROM User_Model u WHERE u.name LIKE   '%:?1%'  " )
    List<User_Model> findByNameContaining(String keyword);
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM user u WHERE u.email = :email AND u.password = md5(:password)", nativeQuery=true)
    List<User_Model> show(@Param("email") String email, @Param("password") String password);

    @Query("SELECT u FROM User_Model u WHERE u.email = ?1")
    User_Model findByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM user u WHERE u.email = :email AND u.code = :code", nativeQuery=true)
    List<User_Model> findByEmailAndCode(@Param("email") String email, @Param("code") String code);
}

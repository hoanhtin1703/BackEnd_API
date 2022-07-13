package com.example.demo.repo;

import com.example.demo.model.Contact_Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactReposity extends JpaRepository<Contact_Model,Long> {

}

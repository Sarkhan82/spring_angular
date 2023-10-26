package com.david.spring_angular.repositories;

import com.david.spring_angular.dto.ContactDto;
import com.david.spring_angular.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findAllByUserId(Integer userId);
}

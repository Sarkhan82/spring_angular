package com.david.spring_angular.repositories;

import com.david.spring_angular.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}

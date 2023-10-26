package com.david.spring_angular.repositories;

import com.david.spring_angular.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}

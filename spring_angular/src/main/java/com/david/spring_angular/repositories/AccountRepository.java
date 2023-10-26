package com.david.spring_angular.repositories;

import com.david.spring_angular.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}

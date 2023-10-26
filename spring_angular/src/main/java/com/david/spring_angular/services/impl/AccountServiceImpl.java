package com.david.spring_angular.services.impl;

import com.david.spring_angular.dto.AccountDto;
import com.david.spring_angular.repositories.AccountRepository;
import com.david.spring_angular.services.AccountService;
import com.david.spring_angular.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final ObjectsValidator<AccountDto> validator;
    @Override
    public Integer save(AccountDto dto) {
        return null;
    }

    @Override
    public List<AccountDto> findAll() {
        return null;
    }

    @Override
    public AccountDto findById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}

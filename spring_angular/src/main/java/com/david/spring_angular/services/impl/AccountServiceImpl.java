package com.david.spring_angular.services.impl;

import com.david.spring_angular.dto.AccountDto;
import com.david.spring_angular.exceptions.ObjectNonPermittedException;
import com.david.spring_angular.models.Account;
import com.david.spring_angular.repositories.AccountRepository;
import com.david.spring_angular.services.AccountService;
import com.david.spring_angular.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final ObjectsValidator<AccountDto> validator;
    @Override
    public Integer save(AccountDto dto) {
        // Block account update -> iban cannot be changed
/*        if (dto.getId() != null) {
            throw new ObjectNonPermittedException(
                    "Account cannot be updated",
                    "save account",
                    "Account",
                    "Update not permitted"
            );
        }*/
        validator.validate(dto);
        Account account = AccountDto.toEntity(dto);
        boolean userHasAlreadyAnAccount = repository.findByUserId(account.getUser().getId()).isPresent();
        if(userHasAlreadyAnAccount && account.getUser().isActive()) {
            throw new ObjectNonPermittedException(
                    "The selected user has already an active account",
                    "Create Account",
                    "Account service",
                    "Account Creation"
            );
        }
        // Generate random IBAN when creating new account else do not update the IBAN
        if (dto.getId() == null) {
            account.setIban(generateRandomIban());
        }
        return repository.save(account).getId();
    }

    @Override
    public List<AccountDto> findAll() {
        return repository.findAll()
                .stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto findById(Integer id) {
        return repository.findById(id)
                .map(AccountDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No account was found with the ID : " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);

    }

    private String generateRandomIban() {
        // Generate an IBAN
        String iban = Iban.random(CountryCode.DE).toFormattedString();

        // Check if the IBAN already exists
        boolean ibanExist = repository.findByIban(iban).isPresent();

        // if exist => Generate new ramdom IBAN
        if (ibanExist) {
            generateRandomIban();
        }
        // if not exist => return generaterd IBAN
        return iban;
    }
}

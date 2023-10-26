package com.david.spring_angular.services.impl;

import com.david.spring_angular.dto.UserDto;
import com.david.spring_angular.models.User;
import com.david.spring_angular.repositories.UserRepository;
import com.david.spring_angular.services.UserService;
import com.david.spring_angular.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ObjectsValidator<UserDto> validator;
    @Override
    public Integer save(UserDto dto) {
        validator.validate(dto);
        User user = UserDto.toEntity(dto);
        return repository.save(user).getId();
    }

    @Override
    public List<UserDto> findAll() {
        return repository.findAll()
                .stream()
                // .map(u -> UserDto.fromEntity(u)
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        return repository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No user was found with the provided ID : " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

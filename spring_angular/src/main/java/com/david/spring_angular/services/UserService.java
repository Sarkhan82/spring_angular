package com.david.spring_angular.services;

import com.david.spring_angular.dto.AuthenticationRequest;
import com.david.spring_angular.dto.AuthenticationResponse;
import com.david.spring_angular.dto.UserDto;

public interface UserService extends AbstractService<UserDto> {

    Integer validateAccount(Integer id);

    Integer invalidateAccount(Integer id);

    AuthenticationResponse register(UserDto user);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}

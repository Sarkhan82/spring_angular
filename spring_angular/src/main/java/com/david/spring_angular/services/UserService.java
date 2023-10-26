package com.david.spring_angular.services;

import com.david.spring_angular.dto.UserDto;

public interface UserService extends AbstractService<UserDto> {

    Integer validateAccount(Integer id);

    Integer invalidateAccount(Integer id);
}

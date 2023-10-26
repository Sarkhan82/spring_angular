package com.david.spring_angular.services;

import com.david.spring_angular.dto.ContactDto;

import java.util.List;

public interface ContactService extends AbstractService<ContactDto> {

    List<ContactDto> findAllByUserId(Integer userId);
}

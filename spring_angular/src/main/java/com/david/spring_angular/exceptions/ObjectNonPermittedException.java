package com.david.spring_angular.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ObjectNonPermittedException extends RuntimeException {

    private final String ErrorMsg;

    private String operationId;

    private final String source;

    private String dependency;


}

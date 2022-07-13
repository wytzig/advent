package com.wytzig.lw.nl.advent.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InvalidListOperationExceptionTests extends RuntimeException{
    public InvalidListOperationExceptionTests(String message) {
        super(message);
    }
}

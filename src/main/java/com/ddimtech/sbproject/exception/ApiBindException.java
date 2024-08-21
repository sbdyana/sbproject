package com.ddimtech.sbproject.exception;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

public class ApiBindException extends BindException {
  public ApiBindException(BindingResult bindingResult) {
    super(bindingResult);
  }
}
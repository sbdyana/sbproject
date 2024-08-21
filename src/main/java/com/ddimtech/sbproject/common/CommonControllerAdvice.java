package com.ddimtech.sbproject.common;

import com.ddimtech.sbproject.exception.ApiBindException;
import com.ddimtech.sbproject.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class CommonControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiBindException.class)
    public ResponseEntity<CommonResult> bindException(ApiBindException e) {
        log.error(e.getMessage());

        Map<String, String> errors = new HashMap<>();

        for (FieldError err : e.getFieldErrors()) {
            errors.put(err.getField(), err.getDefaultMessage());
        }

        CommonResult commonResult = CommonResult.error(CommonResultCode.BAD_REQUEST, errors);
        return ResponseEntity.ok().
                body(commonResult);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CommonResult> resourceNotFoundException(ResourceNotFoundException e) {
        log.error(e.getMessage());

        CommonResult commonResult = CommonResult.error(CommonResultCode.RESOURCE_NOT_FOUND);
        return ResponseEntity.ok().
                body(commonResult);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonErrorResponse> internalServerError(Exception e) {
        log.error(e.getMessage());

        CommonErrorResponse commonErrorResponse = CommonErrorResponse.builder()
                .code(CommonErrorCode.INTERNAL_SERVER_ERROR.getErrCode())
                .message(CommonErrorCode.INTERNAL_SERVER_ERROR.getErrMessage())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(commonErrorResponse);
    }
}


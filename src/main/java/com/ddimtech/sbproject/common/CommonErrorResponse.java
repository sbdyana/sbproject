package com.ddimtech.sbproject.common;

import lombok.Builder;

@Builder
public class CommonErrorResponse {
    private int code;
    private String message;
}

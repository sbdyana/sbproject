package com.ddimtech.sbproject.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode {
    INTERNAL_SERVER_ERROR(5000, "internal server error");

    private final int errCode;
    private final String errMessage;

}

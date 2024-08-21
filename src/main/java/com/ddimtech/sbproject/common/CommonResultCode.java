package com.ddimtech.sbproject.common;

import lombok.Getter;

@Getter
public enum CommonResultCode {
    /**
     * 성공
     */
    SUCCESS(200, "success"),

    /**
     * client error 4xx
     */
    BAD_REQUEST(400, "bad request"),
    RESOURCE_NOT_FOUND(404, "requested resource could not be found"),

    /**
     * server error 5xx
     */
    INTERNAL_SERVER_ERROR(500, "there was a problem with data processing, contact the administrator.");

    private final int resultCode;
    private final String message;

    private CommonResultCode(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public CommonResultCode ok() {
        return SUCCESS;
    }
}


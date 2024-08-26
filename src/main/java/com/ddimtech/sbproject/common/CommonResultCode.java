package com.ddimtech.sbproject.common;

import lombok.Getter;

// 이 어노테이션은 Lombok 라이브러리에서 제공하는 기능으로, 클래스 내의 모든 필드에 대해 자동으로 getter 메서드를 생성
@Getter
// 고정된 상수 집합 정의
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

    // resultCode와 message라는 두 개의 필드를 갖는다.
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


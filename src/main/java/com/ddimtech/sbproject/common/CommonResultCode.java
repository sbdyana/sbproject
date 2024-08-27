package com.ddimtech.sbproject.common;

import lombok.Getter;

@Getter
// 열거형 정의(상수들의 집합)
// API 응답 상태코드와 메세지 정의
// enum 클래스는 싱글톤 패턴을 구현하는 데 사용됨. 이는 enum 클래스 내에서 정의된 상수가 애플리케이션 전체에서 단 하나의 인스턴스만 존재함을 보장하기 때문.
public enum CommonResultCode {
    /**
     * 성공
     */
    // 성공을 나타내는 상수로, HTTP 상태 코드와 success 메시지를 갖는다.
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

    // final로 초기되어 있는 필드들 > 한 번 초기화된 후에는 값이 변경되지 않는다.
    private final int resultCode;
    private final String message;

    // 생성자 private
    // 싱글톤 패턴은 클래스의 인스턴스를 하나만 생성하도록 제한하는 디자인 패턴으로 이를 위해 생성자를 private으로 선언하고 클래스 내부에서 단 하나의 인스턴스를 생성하여 공유한다.
    // 이런 경우 외부에서 new CommonResultCode()를 호출할 수 없고
    private CommonResultCode(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public CommonResultCode ok() {
        return SUCCESS;
    }
}


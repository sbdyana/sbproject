package com.ddimtech.sbproject;

import com.ddimtech.sbproject.common.BeanContext;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@RequiredArgsConstructor
public class SbprojectApplication {

    //Spring의 ApplicationContext를 클래스의 필드로 선언
    //final로 필드가 한 번 초기화되면 그 후에 변경될 수 없음
    //ApplicationContext는 Spring Framework의 핵심 인터페이스 중 하나로 Application의 구성 정보를 제공하는 중앙 인터페이스 역할을 함.
    private final ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(SbprojectApplication.class, args);
    }

    @PostConstruct
    public void init(){
        BeanContext.init(context);
    }

}

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

    private final ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(SbprojectApplication.class, args);
    }

    @PostConstruct
    public void init(){
        BeanContext.init(context);
    }

}

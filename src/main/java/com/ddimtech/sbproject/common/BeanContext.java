package com.ddimtech.sbproject.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationContext;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContext {

    private static ApplicationContext context;

    public static void init(ApplicationContext context){
        BeanContext.context = context;
    }

    public static <T> T get(Class<T> clazz){
        return context.getBean(clazz);
    }

}

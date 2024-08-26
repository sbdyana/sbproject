package com.ddimtech.sbproject.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Counfiguration 어노테이션이 붙은 클래스는 Spring이 애플리케이션 컨텍스트를 초기화할 때 해당 클래스를 설정 클래스로 인식한다.
// 이 어노테이션이 붙은 클래스는 Bean을 정의하고 환경 설정을 지정하는 데 사용되며 이 클래스 내부의 Bean 메서드를 통해 스프링 컨테이너가 관리하는 객체를 생성할 수 있다.
// 이러한 설정 클래스르 통해 애플리케이션이 실행될 때 필요한 다양한 설정과 빈을 정의할 수 있다.
@Configuration
public class SwaggerConfig {

    // Bean 어노테이션이 붙은 메서드가 반환하는 객체는 Spring 컨테이너에 의해 관리되며 다른 Bean에서 의존성 주입으로 사용될 수 있다.
    // 기본적으로 Configuration 클래스에서 정의된 빈은 싱글톤으로 관리된다. 즉 한 번 생성된 빈은 스프링 컨테이너 내에서 동일한 인스턴스를 공유한다.
    @Bean
    public OpenAPI openAPI() {

        Info info = new Info().title("Sbproject Dept API 명세서").version("v1")
                .description("""
                        * GET, POST 만 사용합니다.
                """);

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
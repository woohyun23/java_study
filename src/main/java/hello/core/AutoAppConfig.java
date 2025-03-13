package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.util.Map;
import java.util.Objects;

@Configuration
//@Component를 찾아서 전부 자동으로 Spring Bean으로 등록
@ComponentScan(
        // ComponentScan을 스캔 시작 위치 설정
        // basePackage 설정을 하지 않으면, 이 class파일에 등록된 package인 hello.core의 모든 파일을 스캔
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,

        // AppConfig에 설정되어 있는 Bean들을 추가하지 않도록 설정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
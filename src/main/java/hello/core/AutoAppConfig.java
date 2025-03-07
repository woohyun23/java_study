package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//@Component를 찾아서 전부 자동으로 Spring Bean으로 등록
@ComponentScan(
        // AppConfig에 설정되어 있는 Bean들을 추가하지 않도록 설정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}

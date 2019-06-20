package kr.or.ddit.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//defaultFilter : @Controller, @Service, @Repository, @Component
// ex : @Controller만 스캔
@Configuration
@ComponentScan(basePackages = {"kr.or.ddit"}, useDefaultFilters = true)
public class ApplicationIocBeanScanConfig {
	
}

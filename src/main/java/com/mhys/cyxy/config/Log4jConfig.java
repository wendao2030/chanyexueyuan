package com.mhys.cyxy.config;

import com.mhys.cyxy.Application;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Log4jConfig {

    @Bean
    public void Init(){
        PropertyConfigurator.configure(
                Application.class.getClassLoader().getResourceAsStream("log4j.properties")
        );
    }
}

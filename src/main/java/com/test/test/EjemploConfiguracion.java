package com.test.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EjemploConfiguracion {

    @Bean
    public EjemploVersion crearVersion() {
        return new EjemploVersion("1.0.0");
    }

}

package com.app.plsql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootMybatisPlsqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisPlsqlApplication.class, args);
    }

}

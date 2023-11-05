package com.zsy.language_tutor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("mapper")
public class LanguageTutorApplication {

    public static void main(String[] args) {
        SpringApplication.run(LanguageTutorApplication.class, args);
    }

}

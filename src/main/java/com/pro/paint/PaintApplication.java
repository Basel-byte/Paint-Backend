package com.pro.paint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class PaintApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaintApplication.class, args);
    }

}

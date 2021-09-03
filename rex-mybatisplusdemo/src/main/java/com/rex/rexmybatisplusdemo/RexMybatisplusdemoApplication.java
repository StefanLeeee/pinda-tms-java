package com.rex.rexmybatisplusdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rex.rexmybatisplusdemo.mapper")
public class RexMybatisplusdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RexMybatisplusdemoApplication.class, args);
    }

}

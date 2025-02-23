package com.example.integerview_test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.integerview_test.mapper"})
public class IntegerviewTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegerviewTestApplication.class, args);
    }



}

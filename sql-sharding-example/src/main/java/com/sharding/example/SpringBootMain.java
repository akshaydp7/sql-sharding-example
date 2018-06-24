package com.sharding.example;

import com.sharding.example.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootMain {

    public static void main(final String[] args) {
        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootMain.class, args)) {
            applicationContext.getBean(OrderService.class).insertAndReadDemo();
        } catch (Exception e ){
            System.out.println("Exception in main " + e.getMessage());
        }
    }
}
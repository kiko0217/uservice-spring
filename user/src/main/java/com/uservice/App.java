package com.uservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(
  basePackages = "com.uservice.client"
)
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}

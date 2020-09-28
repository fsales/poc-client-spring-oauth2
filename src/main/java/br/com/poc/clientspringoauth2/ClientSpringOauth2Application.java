package br.com.poc.clientspringoauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClientSpringOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(ClientSpringOauth2Application.class, args);
    }

}

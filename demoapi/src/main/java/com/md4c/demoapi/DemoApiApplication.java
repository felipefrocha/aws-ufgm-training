package com.md4c.demoapi;

import com.md4c.demoapi.domain.entity.Currency;
import com.md4c.demoapi.domain.entity.UserI;
import com.md4c.demoapi.domain.repository.CurrencyRepository;
import com.md4c.demoapi.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class DemoApiApplication {

    @Autowired private CurrencyRepository currencyRepository;
    @Autowired private UserRepository userRepository;

    public static void main(String[] args) {SpringApplication.run(DemoApiApplication.class, args); }

    @Bean
    CommandLineRunner runner() {
        return args -> {
//            Save demo data after start
            userRepository.save(new UserI("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG"));
            currencyRepository.save(new Currency("US Dolar", "USD", new BigDecimal(100), new BigDecimal(3.92)));
            currencyRepository.save(new Currency("Euro", "EUR", new BigDecimal(300), new BigDecimal(4.52)));
        };
    }

}

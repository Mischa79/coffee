package com.example.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseInitializer implements CommandLineRunner {
    @Autowired
    private CoffeeRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.saveAll(
                List.of(
                        new Coffee("Cappuccino", 1.45),
                        new Coffee("Espresso", 2.1),
                        new Coffee("Latte", 2.6),
                        new Coffee("Americano", 2.88),
                        new Coffee("Restretto", 3.14),
                        new Coffee("Flat White", 5.12)

                )
        );
    }
}

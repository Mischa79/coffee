package com.example.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CoffeeService {


    @Autowired
    CoffeeRepository repository;

    public Coffee updateCoffee(Coffee coffee)
    {
        return repository.save(coffee);
    }

    public Iterable<Coffee> getAll()
    {
        return repository.findAll();
    }

    public Optional<Coffee> getCoffeeById(String id)
    {
        return repository.findById(id);
    }

    public Coffee addCoffee(Coffee coffee)
    {
        return repository.save(coffee);
    }
    public void deleteById(String id)
    {
        repository.deleteById(id);
    }

    public long count()
    {
        return repository.count();
    }
}

package com.example.coffee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface CoffeeRepository extends CrudRepository<
        Coffee,
        String
        >
{
    Iterable<Coffee> findByNameContaining(String substring);

     Iterable<Coffee> findByPriceBetween(BigDecimal from, BigDecimal to);

     @Query("SELECT f FROM Coffee f WHERE LOWER(f.name) = LOWER(:name)")
   Optional<Coffee>  retrieveByName(@Param("name") String name);
}


package com.example.coffee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "coffee")

public class Coffee {
    @Id
  private String id;

    @NotBlank(message = "Name should be mandatory")
    //@Max
    //@Min
    //@Pattern
    //@Email
    @Pattern(regexp = ".{5,}", message = "Minimum name length is 5")
    @Column(name = "name")
  private String name;

    @Min(value = 1, message = "Minimum price is 1 euro")
    @Max(value = 10, message = "Maximum price is 10 euro")
    private BigDecimal price;

    public Coffee(String id, String name) {
        this.id = id;
        this.name = name;
        this.price = BigDecimal.ZERO;

    }
    public Coffee(String name, double price)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = BigDecimal.valueOf(price);
    }



    public Coffee(String name) {
        this(UUID.randomUUID().toString(), name);
    }
    public Coffee()
    {
        this(null);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

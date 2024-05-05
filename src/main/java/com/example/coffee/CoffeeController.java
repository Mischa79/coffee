package com.example.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Controller
@RestController
@RequestMapping("/coffees")
public class CoffeeController {
   // private List<Coffee> coffees = new ArrayList<>();

    @Autowired
    private CoffeeRepository repository;

    public CoffeeController() {
    //    coffees.addAll(
    //            List.of(
   //                     new Coffee("Cappuccino"),
    //                    new Coffee("Espresso"),
    //                    new Coffee("Latte"),
    //                    new Coffee("Americano"),
   //                     new Coffee("Restretto"),
    //                    new Coffee("Flat White")
    //            )
    //    );
    }
    //http://localhost:8080/coffees
   // @RequestMapping(value = "/coffees", method = RequestMethod.GET)
    @GetMapping
    public Iterable<Coffee> getAll()
    {
        //return coffees;
        return repository.findAll();
    }
    //GET http://localhost:8080/coffees/findBySubstring?substring=e

    @GetMapping("/findBySubstring")
    public Iterable<Coffee> findByString(
            @RequestParam(name = "substring") String substring
    )
    {
        return repository.findByNameContaining(substring);
    }

    //Post http://localhost:8080/coffees/findByName/Espresso
    @GetMapping("/findByName/{name}")
    public Optional<Coffee> findByName(
            @PathVariable String name
    )
    {
        return repository.retrieveByName(name);
    }



    //GET http://localhost:8080/coffees/findByPriceBetween?from=1&to=4
    @GetMapping("/findByPriceBetween")
    public Iterable<Coffee> findByPriceBetween(
           @RequestParam BigDecimal from,
            @RequestParam BigDecimal to
    )
    {
        return repository.findByPriceBetween(from, to);
    }

    //http://localhost:8080/coffees?id=123
    //http://localhost:8080/coffees/123

   // @RequestMapping(value = "/coffees/{key}", method = RequestMethod.GET)
    @GetMapping("/{key}")
    public Optional <Coffee> getById(@PathVariable(name = "key") String id)
    {
       // return coffees.stream()
             //   .filter(coffee -> coffee.getId().equals(id))
              //  .findFirst();
        return repository.findById(id);
    }

    //http://localhost:8080/coffees/123/delete
    @GetMapping("/{key}/delete")
    public void deleteById(@PathVariable(name = "key") String id)
    {
     //coffees.removeIf(coffee -> coffee.getId().equals(id));
        repository.deleteById(id);
    }

     @DeleteMapping("/{key}")
    public void delete(@PathVariable (name = "key") String id)
    {
        //coffees.removeIf(coffee -> coffee.getId().equals(id));
        repository.deleteById(id);

    }
    //POST http://localhost:8080/coffees
    @PostMapping
    public Coffee add(
           // @RequestBody
            Coffee coffee)
    {
       // coffees.add(coffee);
       return repository.save(coffee);
       // return coffee;
    }

    @PostMapping("/update")
    public Coffee postUpdate(
            Coffee coffee
    )
    {
        return repository.save(coffee);
    }



    //POST http://localhost:8080/coffees/123

    @PostMapping("/{id}")
    public Coffee update(
       @PathVariable(name = "id") String id,
       @RequestBody Coffee coffee
    )
    {
       // for (int i = 0; i < coffees.size(); i++)
       // {
          //  if(coffees.get(i).getId().equals(id))
           // {
             //   coffees.set(i, coffee);
               // break;
          //  }
       // }
        return repository.save(coffee);
    }
}

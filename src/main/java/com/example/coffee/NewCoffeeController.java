package com.example.coffee;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Controller

//@RequestMapping("/new")
public class NewCoffeeController {
    @Autowired
    CoffeeService service;
//GET http://localhost:8080/new/coffees
    @GetMapping("/new/coffees")
    public String getAll(Model model)
    {
      String date = "" + new Date();
      model.addAttribute("mydate", date);
     Iterable<Coffee> coffees = service.getAll();
     model.addAttribute("coffees", coffees);
     return "list";
    }

    @GetMapping("/new/coffees/delete/{id}")
    public String delete(
            @PathVariable String id
    )
    {
     service.deleteById(id);
       return "redirect:/new/coffees";
    }

    @GetMapping("/new/coffees/add")
    public String add(Coffee coffee)
    {
        return "add";
    }


    @PostMapping("/new/coffees")
    public String addCoffee(
            @Valid @ModelAttribute Coffee coffee,
            BindingResult result,
            Model model
    )
    {
        if (result.hasErrors())
            return "add";
        service.addCoffee(coffee);
        return "redirect:/new/coffees";

    }
    @GetMapping("/new/coffees/edit/{id}")
    public String update(
            @PathVariable String id,
            Model model
    )
    {
        Coffee coffee = service.getCoffeeById(id).orElse(null);
        model.addAttribute("coffee", coffee);
        return "update";
    }

    @PostMapping("/new/coffees/update/{id}")
    public String updateCoffee(
            @Valid @ModelAttribute Coffee coffee,
            BindingResult result,
            Model model
    )
    {
        if (result.hasErrors())
            return "update";
        service.updateCoffee(coffee);
        return "redirect:/new/coffees";
    }
}

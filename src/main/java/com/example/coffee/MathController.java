package com.example.coffee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {
    //Get http://localhost:8080/math/sum?first=2&second=3
    @GetMapping("/sum")
   public Double sum (
           @RequestParam Double first,
          @RequestParam Double second
   )
   {
       return (first + second);
   }
}

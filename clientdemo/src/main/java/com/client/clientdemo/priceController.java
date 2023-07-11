package com.client.clientdemo;

import io.opentelemetry.api.trace.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/price")
public class priceController {

    @Autowired
    private priceRepo repo;

    @Autowired
    Tracer tracer;

    @PostMapping
    public String priceSet(@RequestBody priceEntity price){
        repo.save(price);
        return "success:price-save";
    }

    @GetMapping
    public Long getPriceByID(@RequestParam Long id){

        if(tracer!=null){
            System.out.println("Trace " + tracer.toString());
        }

        System.out.println("Here "+id);

        priceEntity price = repo.findById(id).get();
        return  price.getPrice();
    }
}

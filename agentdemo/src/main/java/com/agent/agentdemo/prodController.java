package com.agent.agentdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class prodController {

    @Autowired
    private prodRepo repository;

    @Autowired
    private productService service;
    @PostMapping
    public String createProduct(@RequestBody productEntity product){
        System.out.println("Here");
        product.setPrice(service.getPrice(product.getId()));
        repository.save(product);
        return "success:product-save";
    }

    @GetMapping
    public ResponseEntity<productEntity> getById(@RequestParam Long id){
        return ResponseEntity.ok(repository.findById(id).get());
    }
}

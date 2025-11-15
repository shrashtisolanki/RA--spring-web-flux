package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products") // <-- this ensures your URL works
public class ProductController {

    @Autowired
    private ProductService productService;

    // Fetch all products
    @GetMapping
    public Flux<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Fetch a single product by ID
    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }
}

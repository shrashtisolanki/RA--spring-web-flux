package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = List.of(
            new Product("1", "Laptop", 1200.0),
            new Product("2", "Phone", 800.0),
            new Product("3", "Tablet", 500.0)
    );

    public Flux<Product> getAllProducts() {
        return Flux.fromIterable(products);
    }

    public Mono<Product> getProductById(String id) {
        return Flux.fromIterable(products)
                .filter(p -> p.getId().equals(id))
                .next();
    }
}

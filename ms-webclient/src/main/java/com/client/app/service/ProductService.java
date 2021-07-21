package com.client.app.service;

import com.client.app.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
  
  Flux<Product> findAll();
  Mono<Product> findById(String id);
  Mono<Product> save(Product product);
  Mono<Product> update(Product product,String id);
  Mono<Product> deleteById(String id);
  
}

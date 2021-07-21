package com.client.app.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.client.app.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

   @Autowired
   private WebClient client;
  
  @Override
  public Flux<Product> findAll() {
    return client.get().accept(MediaType.APPLICATION_JSON)
           .retrieve()
         //  .flatMapMany(response -> response.bodyToFlux(Product.class));
           .bodyToFlux(Product.class);
  }

  @Override
  public Mono<Product> findById(String id) {
      Map<String,Object> params =new HashMap<String,Object>();
       params.put("id", id);
    return client.get().uri("/{id}",params)
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(Product.class);
  }

  @Override
  public Mono<Product> save(Product product) {
     
    return client.post()
           .accept(MediaType.APPLICATION_JSON)  
           .contentType(MediaType.APPLICATION_JSON)
           .body(BodyInserters.fromValue(product))
          // .syncBody(product)
           .retrieve()
           .bodyToMono(Product.class);
        
  }     

  @Override
  public Mono<Product> update(Product product, String id) {
    return client.put()
        .uri("/{id}",Collections.singletonMap("id",id))
        .accept(MediaType.APPLICATION_JSON)  
        .contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromValue(product))
       // .syncBody(product)
        .retrieve()
        .bodyToMono(Product.class);
  }
  
  @Override
  public Mono<Product> deleteById(String id) {
    return client.delete().uri("/{id}",Collections.singletonMap("id",id))
       // .exchange()
          .retrieve()
      //  .then();
          .bodyToMono(Product.class);
  }

}

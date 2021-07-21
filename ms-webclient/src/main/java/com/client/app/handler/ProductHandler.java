package com.client.app.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.client.app.model.Product;
import com.client.app.service.ProductService;

import reactor.core.publisher.Mono;

@Component
public class ProductHandler {

  
  @Autowired
  private ProductService service;
  
  private final Logger Logger = LoggerFactory.getLogger(ProductService.class);

  
  public Mono<ServerResponse> list (ServerRequest request){
    Logger.info("send to list product:::::");
     return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
           .body(service.findAll(), Product.class);
  }
  
  public Mono<ServerResponse> see (ServerRequest request){
          String id = request.pathVariable("id");
         return service.findById(id).flatMap(p -> ServerResponse.ok()
           .contentType(MediaType.APPLICATION_JSON)
           .body(BodyInserters.fromValue(p))
            .switchIfEmpty(ServerResponse.notFound().build()));
        //  .body(service.findAll(), Product.class);
 }
  
  
  
  
}

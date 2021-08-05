package com.bank.product.service.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebExchangeBindException;

import com.bank.product.service.domain.dto.ProductDTO;
import com.bank.product.service.domain.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/product")
public class ProductController {

  @Autowired
  private ProductService productService;

      
      @GetMapping(value = "/{id}")
      public Mono<ResponseEntity<ProductDTO>> findProductById(@PathVariable("id") String id) {
        return  productService.findById(id).map(p -> ResponseEntity.ok()
                       .contentType(MediaType.APPLICATION_JSON)
                       .body(p))
                       .defaultIfEmpty(ResponseEntity.notFound().build());
     }
      
      @GetMapping()
      public Mono<ResponseEntity<Flux<ProductDTO>>> findAllProduct() {
          return Mono.just(ResponseEntity.ok()
                 .contentType(MediaType.APPLICATION_JSON)
                 .body(productService.findAll()));                
      }
      
      @PostMapping
      public Mono<ResponseEntity<ProductDTO>> create(@RequestBody Mono<ProductDTO>  monoProducto){      
          return productService.create(monoProducto).map(p-> ResponseEntity
                  .created(URI.create("/api/product/".concat(p.getId())))
                  .contentType(MediaType.APPLICATION_JSON)
                  .body(p));
        }
      
      @PutMapping(value = "/{id}")
      @ResponseStatus(HttpStatus.OK)
      public Mono<ProductDTO> update(@PathVariable("id") String id,@RequestBody Mono<ProductDTO> p) {
          return productService.update(id, p);
      }
      
      @DeleteMapping(value = "/{id}") 
      @ResponseStatus(HttpStatus.OK)
      public Mono<ProductDTO> delete(@PathVariable("id") String id) {
       return  productService.delete(id);
      }
    	
      
     /* @DeleteMapping("/{id}")
      public Mono<ResponseEntity<Void>> delete(@PathVariable String id){
          return productService.findById(id).flatMap(p ->{
              return productService.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
          }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
      }
      */
    }

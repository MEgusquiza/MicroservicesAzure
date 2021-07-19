package com.bank.product.service.controller;

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

import com.bank.product.service.domain.dto.ProductDTO;
import com.bank.product.service.domain.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping(value = { "/save", "/" })
  @ResponseStatus(HttpStatus.OK)
  public Mono<ProductDTO>  createProduct(@RequestBody Mono<ProductDTO> productDto) {
   return productService.create(productDto);
  }
  
  @GetMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Mono<ProductDTO>> findProductById(@PathVariable("id") String id) {
      Mono<ProductDTO> e = productService.findById(id);
      HttpStatus status = (e != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
      return new ResponseEntity<>(e, status);
  }
  
  @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public Flux<ProductDTO> findAllProduct() {
      return productService.findAll();
  }
  
  @PutMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<ProductDTO> update(@PathVariable("id") String id,@RequestBody Mono<ProductDTO> e) {
      return productService.update(id, e);
  }
  
  @DeleteMapping(value = "/delete/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("id") String id) {
    productService.deleteById(id).subscribe();
  }
	
}

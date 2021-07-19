package com.bank.manage.customer.controller;


import com.bank.manage.customer.domain.service.CustomerService;
import com.bank.manage.customer.persistence.entity.Customer;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {
  private final Logger Logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
	private CustomerService  customerService;
	
    @GetMapping("/{id}")  
    public Mono<ResponseEntity<Customer>> getCustomer(@PathVariable("id") String id) {  
      Logger.debug(" EndPoint get by customer {} ", id);
      return customerService.findById(id).map(p -> ResponseEntity.ok()
           .contentType(MediaType.APPLICATION_JSON)
           .body(p))
            .defaultIfEmpty(ResponseEntity.notFound().build());
       }
      
    @GetMapping 
    public Mono<ResponseEntity<Flux<Customer>>> getAllCustomers() {
      Logger.info(" EndPoit get by all customers {} ");
      return Mono.just(ResponseEntity.ok()
       .contentType(MediaType.APPLICATION_JSON)
       .body(customerService.findAll())
          );
      }
    
    @PostMapping
    public Mono<ResponseEntity<Customer>> createCustomer(@RequestBody Customer customer){
       return customerService.create(customer).map(p-> ResponseEntity
          .created(URI.create("/customer/".concat(p.getId())))
          .contentType(MediaType.APPLICATION_JSON)
          .body(p)
          );
     }
       
    @PutMapping("/{id}")
    public Mono<ResponseEntity<Customer>> updateCustomer(@RequestBody Customer customer, @PathVariable String id){
      Logger.debug("Updating User with customer-id = {}.", id);
      return customerService.findById(id).flatMap(c -> {
            c.setFirstName(customer.getFirstName());
            c.setLastName(customer.getLastName());
            c.setDocumentType(customer.getDocumentType());
            c.setMail(customer.getMail());
            c.setPhone(customer.getPhone());
            c.setState(customer.getState());
            return customerService.update(id,c);
        }).map(p->ResponseEntity.created(URI.create("/customer/".concat(p.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(p))
        .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteCustomer(@PathVariable String id){
      Logger.debug("delete customer by Id {}", id);
      return customerService.delete(id) .map(ResponseEntity::ok);
    }
    
    @GetMapping(value = "/name/{name}")
 //   @ResponseStatus(HttpStatus.OK)
    public Mono<Customer> findByName(@PathVariable("name") String name) {
        return customerService.findByFirstName(name);
    }
    
    
    public Mono<ResponseEntity<String>> allCustomers(Exception e) {
      Logger.info("FallBackMethod");
      return Mono.just("Service is down. Please, try later." +
              "\nSend this message to the administrator"+e.getMessage())
              .map(p-> new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR));
  }    
    
    
    
}

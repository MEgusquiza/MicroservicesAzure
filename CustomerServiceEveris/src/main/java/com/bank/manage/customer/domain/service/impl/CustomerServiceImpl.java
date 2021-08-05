package com.bank.manage.customer.domain.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.bank.manage.customer.domain.repository.CustomerRepository;
import com.bank.manage.customer.domain.service.CustomerService;
import com.bank.manage.customer.persistence.entity.Customer;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {
  private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	   @Autowired
	   private CustomerRepository customerRepository;
	   

      @Override
      public Mono<Customer> findById(String id) {
        return customerRepository.findById(id);
      }

      @Override
      public Flux<Customer> findAll() {
        return customerRepository.findAll();
      }

      @Override
      public Mono<Customer> update(String id, Customer customer) {
        return customerRepository.save(customer);
      }

      @Override
      public Mono<Customer> create(Customer customer) {
       return customerRepository.insert(customer);
      }

      @Override
      public Mono<Void> delete(String id) {
        return customerRepository.deleteById(id);
      }

      @Override
      public Mono<Customer> findByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
      }
      
    
      
}

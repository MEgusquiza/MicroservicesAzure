package com.bank.manage.customer.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.bank.manage.customer.persistence.entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer,String> {
    public Mono<Customer> findByFirstName(String firstName);
}

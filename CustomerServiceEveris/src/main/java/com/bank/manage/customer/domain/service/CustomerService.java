package com.bank.manage.customer.domain.service;

import com.bank.manage.customer.persistence.entity.Customer;

import reactor.core.publisher.Mono;


public interface CustomerService extends MaintenanceService<Customer> {

  public Mono<Customer> findByFirstName(String firstName);
}

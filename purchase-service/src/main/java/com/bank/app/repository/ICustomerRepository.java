package com.bank.app.repository;



import com.bank.app.model.Customer;

import reactor.core.publisher.Mono;

public interface ICustomerRepository extends IRepository<Customer, String> {
	Mono<Customer> findByIdentityNumber(String identityNumber);
}

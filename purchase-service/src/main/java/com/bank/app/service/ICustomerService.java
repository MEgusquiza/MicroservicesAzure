package com.bank.app.service;


import com.bank.app.model.Customer;

import reactor.core.publisher.Mono;

public interface ICustomerService extends ICRUDService<Customer, String> {
	Mono<Customer> findByIdentityNumber(String identityNumber);
}

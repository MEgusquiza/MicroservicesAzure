package com.bank.app.service;

import java.util.List;

import com.bank.app.model.Purchase;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPurchaseService extends ICRUDService<Purchase, String> {
	
//	Flux<Purchase> findByCustomerOwner(List<Customer> customers);
	
	Mono<List<Purchase>> findByIdentityNumberAndProductID(String identityNumber, String idProduct);


}

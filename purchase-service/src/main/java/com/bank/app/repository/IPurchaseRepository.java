package com.bank.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;

import com.bank.app.model.Purchase;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPurchaseRepository extends IRepository<Purchase, String> {
	
//	Flux<Purchase> findByCustomerOwner(List<Customer> customers);
	
	@Query(value="{ 'customerOwner.identityNumber' : ?0  }")
	Mono<List<Purchase>> findByIdentityNumberAndProductID(String identityNumber, String idProduct);
	
}

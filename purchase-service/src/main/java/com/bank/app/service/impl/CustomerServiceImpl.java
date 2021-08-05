package com.bank.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.model.Customer;
import com.bank.app.repository.ICustomerRepository;
import com.bank.app.repository.IRepository;
import com.bank.app.service.ICustomerService;

import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl extends CRUDServiceImpl<Customer, String> implements ICustomerService {

	@Autowired
	private ICustomerRepository repository;

	@Override
	protected IRepository<Customer, String> getRepository() {

		return repository;

	}

	@Override
	public Mono<Customer> findByIdentityNumber(String identityNumber) {
		return repository.findByIdentityNumber(identityNumber);
	}

}

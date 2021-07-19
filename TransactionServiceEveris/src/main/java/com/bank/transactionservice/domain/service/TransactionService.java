package com.bank.transactionservice.domain.service;

import com.bank.transactionservice.persistence.entity.Customer;
import com.bank.transactionservice.persistence.entity.Product;
import com.bank.transactionservice.persistence.entity.Representative;
import com.bank.transactionservice.persistence.entity.Transaction;

import reactor.core.publisher.Mono;


public interface TransactionService extends MaintenanceService<Transaction>{

	public Customer findCustomerByNumDoc(String numDoc);
	public Product findProductByIdProduct(String idProduct);	
	public boolean validateRepresentative(Representative[] representative);
	public long countAccountByCustomer(Transaction transaction);
    public Mono<Void> deleteByIdCustomer(String id);
    public Representative findDataRepresentative(Representative representative);
	public Representative[] findRepresentativesByNumDocRep(Representative[] representatives);
    
}

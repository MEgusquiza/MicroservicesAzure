package com.bank.transaction.domain.service;

import com.bank.transaction.model.Customer;
import com.bank.transaction.model.Product;
import com.bank.transaction.model.Representative;
import com.bank.transaction.model.Transaction;

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

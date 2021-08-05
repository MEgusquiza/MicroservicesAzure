package com.bank.app.topic.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.bank.app.model.Customer;
import com.bank.app.model.Product;
import com.bank.app.model.Purchase;
import com.bank.app.model.Transaction;
import com.bank.app.service.ICustomerService;
import com.bank.app.service.IProductService;
import com.bank.app.service.IPurchaseService;
import com.bank.app.topic.producer.PurchaseProducer;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.Disposable;
import reactor.core.publisher.Mono;

//@Component
public class Consumer {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private IPurchaseService purchaseService;
	
	@Autowired
	private PurchaseProducer producer;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@KafkaListener(topics = "saved-product-topic", groupId = "purchase-group")
	public Disposable retrieveSavedProduct(String data) throws Exception {
			
		Product product = objectMapper.readValue(data, Product.class);
		
		return Mono.just(product)
				.log()
				.flatMap(productService::update)
				.subscribe();
		
	}
	
	@KafkaListener(topics = "saved-customer-topic", groupId = "purchase-group")
	public Disposable retrieveSavedCustomer(String data) throws Exception {
		
		Customer customer = objectMapper.readValue(data, Customer.class);
		
		return Mono.just(customer)
				.log()
				.flatMap(customerService::update)
				.subscribe();
		
	}
	
	@KafkaListener(topics = "created-transaction-topic", groupId = "purchase-group")
	public Disposable retrieveCreatedTransaction(String data) throws Exception {
		
		Transaction transaction = objectMapper.readValue(data, Transaction.class);
		
		Mono<Purchase> monoPurchase = purchaseService.findById(transaction.getPurchase().getId());
		
		Mono<Transaction> monoTransaction = Mono.just(transaction);
		
		return monoPurchase
				.zipWith(monoTransaction, (a,b) -> {
					if(transaction.getTransactionType().equals("CONSUMO TARJETA CREDITO")) {
						a.setAmountFin(a.getAmountFin() - transaction.getTransactionAmount());
					} else if (transaction.getTransactionType().equals("PAGO TARJETA CREDITO")) {
						a.setAmountFin(a.getAmount());						
					}
					producer.send(a);
					return a;
				})
				.flatMap(purchaseService::update)
				.subscribe();
		
	}
	
}

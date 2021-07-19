package com.bank.transactionservice.domain.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.bank.transactionservice.domain.repository.TransactionRepository;
import com.bank.transactionservice.domain.service.TransactionService;
import com.bank.transactionservice.persistence.entity.Customer;
import com.bank.transactionservice.persistence.entity.Product;
import com.bank.transactionservice.persistence.entity.Representative;
import com.bank.transactionservice.persistence.entity.Transaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements TransactionService {

	
	@Autowired
	private TransactionRepository transactionRepresentative;

	private final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);

	@Value("${msg.error.record.notfound}")
	private String msgErrorNotFound;
	

	private String urlCustomerService;
	private String urlProductService;
	private String urlRepresentativeService;
	private String repTypeTitular;
	private String repIdTypeTitular;
	
	@Override
	public Mono<Transaction> updateEntity(Transaction transaction) {
		LOGGER.info("Transacion services, update");
		return  transactionRepresentative.findById(transaction.getId())
				 .switchIfEmpty(Mono.error( new Exception(msgErrorNotFound) ))
				 .flatMap(item-> transactionRepresentative.save(transaction));
	}

	@Override
	public Mono<Void> deleteEntity(String id) {
		return  transactionRepresentative.findById(id)
				 .switchIfEmpty(Mono.error( new Exception(msgErrorNotFound) ))
				 .flatMap(item-> transactionRepresentative.deleteById(id));
	}

	@Override
	public Customer findCustomerByNumDoc(String numDocument) {
		WebClient webClient = WebClient.create(urlCustomerService);
	    return  webClient.get()
	    		.uri("/customer/{numDoc}",numDocument)
	    		.retrieve()
	    		.bodyToMono(Customer.class)
	    		.switchIfEmpty(Mono.error( new Exception(msgErrorNotFound) ))
	    		.share().block();
	}

	@Override
	public Product findProductByIdProduct(String idProduct) {
		WebClient webClient = WebClient.create(urlProductService);
	    return  webClient.get()
	    		.uri("/product/{idProduct}",idProduct)
	    		.retrieve()
	    		.bodyToMono(Product.class)
	    		.switchIfEmpty(Mono.error( new Exception(msgErrorNotFound) ))
	    		.share().block();
	}
	
	@Override
	public Representative[] findRepresentativesByNumDocRep(Representative[] representative) {
		List<Representative> listRepr= Arrays.asList(representative);
		List<Representative> listRepNew= new ArrayList<>();
		listRepNew = listRepr.stream().map(rep-> findDataRepresentative(rep)).collect(Collectors.toList());
		Representative[] reprArr= new Representative[listRepNew.size()];
		return listRepNew.toArray(reprArr);
	}
	
	@Override
	public boolean validateRepresentative(Representative[] representative) {
		List<Representative> listRepr= Arrays.asList(representative);
		long count = listRepr.stream()
				.filter(rep-> rep.getTypeRepresentative().equalsIgnoreCase(repIdTypeTitular)  || rep.getTypeRepresentative().equalsIgnoreCase(repTypeTitular)) 
				.count();
		if(count > 1)
			return false;
		
		return true;
	}
	
	@Override
	public Representative findDataRepresentative(Representative rep) {
		WebClient webClient = WebClient.create(urlRepresentativeService);
		Representative represetante=  webClient.get()
	    		.uri("/representative/{numDocRepresentative}",rep.getNumDocRepresentative())
	    		.retrieve()
	    		.bodyToMono(Representative.class)
	    		.switchIfEmpty(Mono.error( new Exception(msgErrorNotFound) ))
	    		.share().block();
		represetante.setTypeRepresentative(rep.getTypeRepresentative());
		
		return represetante;
	}
	
	@Override
	public Flux<Transaction> findAll() {
		return transactionRepresentative.findAll();
	}

	@Override
	public Mono<Transaction> findEntityById(String id) {
		return null;
	}

	@Override
	public Mono<Transaction> createEntity(Transaction entity) {
		return null;
	}

	@Override
	public Mono<Void> deleteByIdCustomer(String id) {
		return null;
	}

	@Override
	public long countAccountByCustomer(Transaction transaction) {
		return 0;
	}

	
 
}

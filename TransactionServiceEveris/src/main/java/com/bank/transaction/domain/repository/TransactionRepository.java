package com.bank.transaction.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bank.transaction.model.Transaction;



@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transaction,String> {
 
}

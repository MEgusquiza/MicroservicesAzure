package com.bank.transactionservice.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bank.transactionservice.persistence.entity.Transaction;



@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transaction,String> {
 
}

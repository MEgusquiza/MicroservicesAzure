package com.bank.transactionservice.persistence.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document(collection = "docTransaction")
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction{

	@Id
	private String id;
	
	@Field(name = "numAccount")
    private String numberAccount;
	
	@Field(name = "typeTrans")
    private String typeTransaction;
	
    @Field(name = "chargeCred")
    private double chargeCredit;
    
    @Field(name = "descTra")
    private String descTransaction;
    
    @Field(name = "amountLend")
    private double amountLendig;
    
	@Field(name = "limitCred")
    private double limitCredit;
	
	@Field(name = "balaces")
    private double balance;
    
	@Field(name = "dateTra")
    private Date dateTransaction;
	
    @Field(name = "state")
    private long status;
	
    private Customer customer;
    
    private Product product;
    
    private Representative[] representative;
  
	
}

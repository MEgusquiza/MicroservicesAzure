package com.bank.transactionservice.persistence.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "docProduct")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Field(name = "idProd")
	private String productId;
	
	@Field(name = "nameProd")
    private String productName;
	
	@Field(name = "typeProd")
    private String productType;


}

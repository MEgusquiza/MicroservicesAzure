package com.bank.transactionservice.persistence.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "docMovement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movement {
  
	@Field(name = "amountMov")
    private Double amountMovement;
	@Field(name = "typeMov")
	private String typeMovement;
	@Field(name = "dateMov")
    private Date dateMovement;
}

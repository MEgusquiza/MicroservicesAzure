package com.bank.transactionservice.persistence.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "docExpedition")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expedition {

	@Field(name = "amountExped")
    private String amountExpedition ;
	@Field(name = "descExped")
    private String descExpedition ;
	@Field(name = "dateExped")
	private Date dateExpedition ;

}

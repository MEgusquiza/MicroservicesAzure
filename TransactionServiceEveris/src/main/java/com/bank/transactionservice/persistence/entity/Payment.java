package com.bank.transactionservice.persistence.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "docPayment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	
	@Field(name = "amountPay")
    private double amountPayment;
	@Field(name = "currencyPay")
	private String currencyType;
	@Field(name = "descPay")
    private String descPayment;
	@Field(name = "datePay")
	private Date datePayment;
}

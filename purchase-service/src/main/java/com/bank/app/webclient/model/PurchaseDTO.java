package com.bank.app.webclient.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.bank.app.model.Customer;
import com.bank.app.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO {

	@Id
	private String id;

	@Field(name = "product")
	private Product product;

	@NotNull @NotEmpty
	@Field(name = "customerOwner")
	private List<Customer> customerOwner;

	@Field(name = "authorizedSigner")
	private List<Customer> authorizedSigner;
	
	@Field(name = "amountIni")
	private double amountIni;
	
	@Field(name = "amountFin")
	private double amountFin;
	
	@Field(name = "cardNumber")
	private String cardNumber;
	
	@Field(name = "purchaseDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime purchaseDate;
	
	@Field(name = "state")
    private char state;
}

package com.bank.transactionservice.persistence.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "docRepresentative")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Representative  {
	

	@Field(name = "numDocRepre")
	private String numDocRepresentative;
	@Field(name = "nameRepre")
    private String nameRepresentative;
	@Field(name = "lastNameRepre")
    private String lastNameRepresentative;
	@Field(name = "typeRepre")
    private String typeRepresentative;

}

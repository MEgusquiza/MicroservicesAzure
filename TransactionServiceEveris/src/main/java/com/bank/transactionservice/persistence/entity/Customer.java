package com.bank.transactionservice.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "docCustomer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer  {	   
	    @Id
	    private String id;
	    @Field(name = "firstNam")
	    private String firstName;
	    @Field(name = "lastNam")
	    private String lastName;
	    @Field(name = "docType")
	    private String documentType ;
	
}

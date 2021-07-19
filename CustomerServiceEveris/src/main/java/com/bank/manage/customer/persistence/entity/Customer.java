package com.bank.manage.customer.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
	    private String firstName;
	    private String lastName;
	    private Integer document;
	    private String documentType ;
	    private String mail;
	    private Integer phone;
	    private String state;
	    
	
	
}

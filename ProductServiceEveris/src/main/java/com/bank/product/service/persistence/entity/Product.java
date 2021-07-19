package com.bank.product.service.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.bank.product.service.persistence.entity.model.ProductDetail;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Document(collection = "product")
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	private String id;
//	@Field(name = "productName")
	private String productName;
//	@Field(name = "productType")
	private String productCategory;
	private String productType  ;
//	@Field(name = "condition")
	private ProductDetail detail;


}

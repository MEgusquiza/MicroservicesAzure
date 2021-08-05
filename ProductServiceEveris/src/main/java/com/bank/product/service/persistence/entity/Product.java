package com.bank.product.service.persistence.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Document(collection = "product")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
  @Id
  private String id;
  @Field(name = "productName")
  private String productName;
  @Field(name = "productType")
  private String productType;
  @Field(name = "condition")
  private Condition condition;

}

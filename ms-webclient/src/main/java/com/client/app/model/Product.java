package com.client.app.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
 

  private String id;
//@Field(name = "productName")
  private String productName;
//@Field(name = "productType")
  private String productCategory;
  private String productType  ;
//@Field(name = "condition")
}

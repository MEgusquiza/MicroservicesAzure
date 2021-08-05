package com.client.app.model;


import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//@JsonInclude(JsonInclude.Include.NON_NULL)
/*@Data
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
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") 
  private LocalDateTime paymentDate = LocalDateTime.now();
  
 
}*/


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Product {
    
    private String id;
    private String productName;
    private String productType;
    private Condition condition;

}

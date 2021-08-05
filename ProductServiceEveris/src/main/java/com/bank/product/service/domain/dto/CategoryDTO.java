package com.bank.product.service.domain.dto;

import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Document(collection = "category")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
  @Id
 private String id;
 private String nombre;
 
}

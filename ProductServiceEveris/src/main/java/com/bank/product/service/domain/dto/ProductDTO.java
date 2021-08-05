package com.bank.product.service.domain.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.bank.product.service.persistence.entity.model.ProductDetail;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @Id
    private String id;
    private String productName;
    private String productCategory;
    private String productType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") 
    private LocalDateTime paymentDate = LocalDateTime.now();
  //  private ProductDetail detail;
}

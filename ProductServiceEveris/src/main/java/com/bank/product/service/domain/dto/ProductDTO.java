package com.bank.product.service.domain.dto;

import org.springframework.data.annotation.Id;

import com.bank.product.service.persistence.entity.model.ProductDetail;

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
    private ProductDetail detail;
}

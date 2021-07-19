package com.bank.product.service.domain.util;

import com.bank.product.service.domain.dto.ProductDTO;
import com.bank.product.service.persistence.entity.Product;

import org.springframework.beans.BeanUtils;

public class AppUtils {

    private AppUtils() {
    }

    public static ProductDTO entityToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    public static Product dtoToEntity(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        return product;
    }


}

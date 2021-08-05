package com.bank.product.service.domain.service;

import com.bank.product.service.domain.dto.ProductDTO;
import com.bank.product.service.persistence.entity.Product;


public interface ProductService extends CRUDService<ProductDTO, String>  {

	//public Mono<Product> getProductByIdProduct(String idProduct);
	

}

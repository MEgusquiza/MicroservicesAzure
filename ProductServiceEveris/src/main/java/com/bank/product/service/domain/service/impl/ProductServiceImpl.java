package com.bank.product.service.domain.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.product.service.domain.dto.ProductDTO;
import com.bank.product.service.domain.repository.ProductRepository;
import com.bank.product.service.domain.service.ProductService;
import com.bank.product.service.domain.util.AppUtils;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductRepository productRepository;
		
  @Override
  public Flux<ProductDTO> findAll() {
	        log.debug("getAll products");
	        return productRepository.findAll().map(AppUtils::entityToDTO);
	    }
  @Override
  public Mono<ProductDTO> findById(String id) {
    log.debug("get product by Id {}",id);
    return productRepository.findById(id).map(AppUtils::entityToDTO);
  }

  @Override
  public Mono<ProductDTO> update(String id, Mono<ProductDTO> entity) {
    log.debug("update product by Id {}",id);
    return productRepository.findById(id)
        .flatMap(p -> entity.map(AppUtils::dtoToEntity)
                .doOnNext(e -> e.setId(id)))
        .flatMap(productRepository::save)
        .map(AppUtils::entityToDTO);
  }

  @Override
  public Mono<ProductDTO> create(Mono<ProductDTO> entity) {
    log.debug("create product ...");
   return entity.map(AppUtils::dtoToEntity)
        .flatMap(productRepository::insert)
        .map(AppUtils::entityToDTO);  
  }

  @Override
  public Mono<ProductDTO> deleteById(String id) {
    log.debug("delete product by Id {}");
    return productRepository.findById(id)
        .flatMap(p -> productRepository.deleteById(p.getId()).thenReturn(p))
        .map(AppUtils::entityToDTO);
  
  }

}

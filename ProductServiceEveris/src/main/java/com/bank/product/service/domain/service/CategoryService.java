package com.bank.product.service.domain.service;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bank.product.service.persistence.entity.Category;

public interface CategoryService extends  CRUDService<Category, String> {

  
  
}

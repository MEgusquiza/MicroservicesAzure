package com.bank.product.service.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bank.product.service.persistence.entity.Category;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String>{

}

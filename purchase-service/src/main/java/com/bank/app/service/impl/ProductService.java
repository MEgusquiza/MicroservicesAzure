package com.bank.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.model.Product;
import com.bank.app.repository.IProductRepository;
import com.bank.app.repository.IRepository;
import com.bank.app.service.IProductService;


@Service
public class ProductService extends CRUDServiceImpl<Product, String> implements IProductService {

	@Autowired
	private IProductRepository repository;

	@Override
	protected IRepository<Product, String> getRepository() {
		return repository;
	}

}

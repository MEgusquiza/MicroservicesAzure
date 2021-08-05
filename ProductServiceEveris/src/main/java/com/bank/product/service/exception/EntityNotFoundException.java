package com.bank.product.service.exception;

public class EntityNotFoundException extends RuntimeException  {

	public EntityNotFoundException(String message) {
        super(message);
        System.out.println("error no found");
    }
}

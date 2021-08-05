package com.bank.transaction.domain.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MaintenanceService<T> {
	public Flux<T> findAll();
	public Mono<T> findEntityById(String id);
	public Mono<T> createEntity(T entity) ;
	public Mono<T> updateEntity(T entity);
	public Mono<Void> deleteEntity(String id);

}

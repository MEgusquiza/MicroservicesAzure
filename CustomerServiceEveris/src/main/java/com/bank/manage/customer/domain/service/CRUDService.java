package com.bank.manage.customer.domain.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CRUDService <T,ID>{
    Mono<T> findById(ID id);
    Flux<T> findAll();
    Mono<T> update(ID id,T entity);
    Mono<T> create(T entity);
    Mono<Void> delete(ID id);

}

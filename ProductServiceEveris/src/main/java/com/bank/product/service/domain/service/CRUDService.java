package com.bank.product.service.domain.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CRUDService <T,ID>{
    Mono<T> findById(ID id);
    Flux<T> findAll();
    Mono<T> update(ID id,Mono<T> entity);
    Mono<T> create(Mono<T> entity);
    Mono<T> deleteById(ID id);
}

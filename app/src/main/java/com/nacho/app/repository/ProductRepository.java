package com.nacho.app.repository;

import com.nacho.app.model.ProductEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveMongoRepository<ProductEntity, Long> {

    Flux<ProductEntity> findByYear(Integer year);
    Mono<ProductEntity> findByName(String name);

}

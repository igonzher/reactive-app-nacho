package com.nacho.app.repository;

import com.nacho.app.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveMongoRepository<Product, Long> {

    Flux<Product> findByYear(Integer year);
    Mono<Product> findByName(String name);

}

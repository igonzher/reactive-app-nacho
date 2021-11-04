package com.nacho.app.service.product;

import com.nacho.app.model.ProductEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    //CRUD
    Mono<ProductEntity> createProduct(ProductEntity productEntity);
    Mono<ProductEntity> updateProduct(ProductEntity productEntity);
    Mono<Void> deleteProduct(ProductEntity productEntity);
    Flux<ProductEntity> getProducts();

    Mono<ProductEntity> getProductByName(String name);
    Flux<ProductEntity> getProductByYear(Integer year);
}

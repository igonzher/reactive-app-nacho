package com.nacho.app.service.product;

import com.nacho.app.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    //CRUD
    Mono<Product> createProduct(Product product);
    Mono<Product> updateProduct(Product product);
    Mono<Void> deleteProduct(Product product);
    Flux<Product> getProducts();

    Mono<Product> getProductByName(String name);
    Flux<Product> getProductByYear(Integer year);
}

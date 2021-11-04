package com.nacho.app.model.useCase.product;


import com.nacho.app.model.ProductEntity;
import com.nacho.app.repository.mapper.ProductMapperImpl;
import com.nacho.app.service.product.ProductServiceImpl;
import model.Product;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateProductUseCase {

    ProductServiceImpl productService;
    ProductMapperImpl productMapper;

    public CreateProductUseCase(ProductServiceImpl productService, ProductMapperImpl personMapperModel){
        this.productService = productService;
        this.productMapper = personMapperModel;
    }

    public Mono<Product> dispacth(ProductEntity productEntity){
        return productService.createProduct(productEntity).map(productCreated ->
                productMapper.productToProductApi(productCreated)
        );
    }
}

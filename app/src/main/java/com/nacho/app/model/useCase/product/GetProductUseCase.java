package com.nacho.app.model.useCase.product;


import com.nacho.app.repository.mapper.ProductMapperImpl;
import com.nacho.app.service.product.ProductServiceImpl;
import model.Product;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class GetProductUseCase {

    ProductServiceImpl productService;
    ProductMapperImpl productMapper;

    public GetProductUseCase(ProductServiceImpl productService, ProductMapperImpl personMapperModel){
        this.productService = productService;
        this.productMapper = personMapperModel;
    }

    public Mono<List<Product>> dispacth(){
        return productService.getProducts().map(product ->
                    productMapper.productToProductApi(product)
                ).collectList();
    }
}

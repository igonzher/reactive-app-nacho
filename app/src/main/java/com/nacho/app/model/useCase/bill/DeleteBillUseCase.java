package com.nacho.app.model.useCase.bill;


import com.nacho.app.repository.mapper.ProductMapperImpl;
import com.nacho.app.service.product.ProductServiceImpl;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DeleteBillUseCase {

    ProductServiceImpl productService;
    ProductMapperImpl productMapper;

    public DeleteBillUseCase(ProductServiceImpl productService, ProductMapperImpl productMapper){
        this.productService = productService;
        this.productMapper = productMapper;
    }

    public Mono<Void> dispacth(String name){
        return productService.getProductByName(name).flatMap(productToDelete ->
                productService.deleteProduct(productToDelete)
                );
    }
}

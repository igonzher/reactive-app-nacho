package com.nacho.app.model.useCase.product;


import com.nacho.app.model.ProductEntity;
import com.nacho.app.repository.mapper.ProductMapperImpl;
import com.nacho.app.service.product.ProductServiceImpl;
import model.Product;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UpdateProductUseCase {

    ProductServiceImpl productService;
    ProductMapperImpl productMapper;

    public UpdateProductUseCase(ProductServiceImpl productService, ProductMapperImpl productMapper){
        this.productService = productService;
        this.productMapper = productMapper;
    }

    public Mono<Product> dispacth(ProductEntity productEntity){

        return productService.getProductByName(productEntity.getName()).map(productToCreate ->
                    productMapper.productToProduct(productToCreate, productEntity)
                ).flatMap(productToCreate ->
                        productService.updateProduct(productToCreate)
                    ).map(productUpdated -> productMapper.productToProductApi(productUpdated));

    }
}
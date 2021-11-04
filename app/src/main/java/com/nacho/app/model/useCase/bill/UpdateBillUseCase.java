package com.nacho.app.model.useCase.bill;


import com.nacho.app.repository.mapper.ProductMapperImpl;
import com.nacho.app.service.product.ProductServiceImpl;
import model.Product;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UpdateBillUseCase {

    ProductServiceImpl productService;
    ProductMapperImpl productMapper;

    public UpdateBillUseCase(ProductServiceImpl productService, ProductMapperImpl productMapper){
        this.productService = productService;
        this.productMapper = productMapper;
    }

    public Mono<Product> dispacth(com.nacho.app.model.Product product){

        return productService.getProductByName(product.getName()).flatMap(producToUpdate ->
                productService.updateProduct(product)
        ).map(productUpdated -> productMapper.productToProductApi(productUpdated));
    }
}
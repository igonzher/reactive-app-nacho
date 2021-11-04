package com.nacho.app.service.product;


import com.nacho.app.exception.ProductNameDuplicateException;
import com.nacho.app.exception.ProductNotFoundException;
import com.nacho.app.model.ProductEntity;
import com.nacho.app.repository.ProductRepository;
import com.nacho.app.repository.mapper.ProductMapperImpl;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    ProductMapperImpl productMapper;

    @Autowired
    ProductServiceImpl(ProductRepository productRepository, ProductMapperImpl productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Mono<ProductEntity> createProduct(ProductEntity productEntity) {
        if (ObjectUtils.isNotEmpty(productRepository.findByName(productEntity.getName()))){
            throw new ProductNameDuplicateException();
        } else{
            return productRepository.save(productEntity);
        }
    }

    @Override
    public Mono<ProductEntity> updateProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public Mono<Void> deleteProduct(ProductEntity productEntity) {
        return productRepository.delete(productEntity);
    }

    @Override
    public Flux<ProductEntity> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Mono<ProductEntity> getProductByName(String name) {
        Mono<ProductEntity> product = productRepository.findByName(name);

        if (ObjectUtils.isNotEmpty(product)){
            return product;
        } else {
            throw new ProductNotFoundException();
        }
    }

    @Override
    public Flux<ProductEntity> getProductByYear(Integer year) {
        Flux<ProductEntity> productList = productRepository.findByYear(year);

        if (ObjectUtils.isNotEmpty(productList)){
            return productList;
        } else {
            throw new ProductNotFoundException();
        }
    }
}

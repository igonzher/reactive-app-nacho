package com.nacho.app.service.product;


import com.nacho.app.exception.ProductNameDuplicateException;
import com.nacho.app.exception.ProductNotFoundException;
import com.nacho.app.model.Product;
import com.nacho.app.repository.ProductRepository;
import com.nacho.app.repository.mapper.ProductMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


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
    public Mono<Product> createProduct(Product product) {
        if (productRepository.findByName(product.getName()).block() != null){
            throw new ProductNameDuplicateException();
        } else{
            return productRepository.save(product);
        }
    }

    @Override
    public Mono<Product> updateProduct(Product product) {

        Product productToUpdate = productRepository.findByName(product.getName()).block();

        productToUpdate = productMapper.productToProduct(productToUpdate, product);
        return productRepository.save(productToUpdate);

    }

    @Override
    public Mono<Void> deleteProduct(Product product) {
        return productRepository.delete(product);
    }

    @Override
    public Flux<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> getProductByName(String name) {
        Product product = productRepository.findByName(name).block();

        if (product != null){
            return productRepository.findByName(name);
        } else {
            throw new ProductNotFoundException();
        }
    }

    @Override
    public Flux<Product> getProductByYear(Integer year) {
        List<Product> productList = productRepository.findByYear(year).collectList().block();

        if (productList != null){
            return productRepository.findByYear(year);
        } else {
            throw new ProductNotFoundException();
        }
    }
}

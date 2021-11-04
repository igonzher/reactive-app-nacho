package com.nacho.app.controller;

import api.ProductApi;
import com.nacho.app.model.ProductEntity;
import com.nacho.app.model.useCase.product.CreateProductUseCase;
import com.nacho.app.model.useCase.product.DeleteProductUseCase;
import com.nacho.app.model.useCase.product.GetProductUseCase;
import com.nacho.app.model.useCase.product.UpdateProductUseCase;
import com.nacho.app.repository.mapper.ProductMapperImpl;
import com.nacho.app.service.product.ProductServiceImpl;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController implements ProductApi {

    private final ProductServiceImpl productService;
    ProductMapperImpl productMapper;

    GetProductUseCase getProductUseCase;
    CreateProductUseCase createProductUseCase;
    UpdateProductUseCase updateProductUseCase;
    DeleteProductUseCase deleteProductUseCase;

    @Autowired
    public ProductController(
            ProductServiceImpl productService, ProductMapperImpl productMapper,
            GetProductUseCase getProductUseCase, CreateProductUseCase createProductUseCase,
            UpdateProductUseCase updateProductUseCase, DeleteProductUseCase deleteProductUseCase

    ) {
        this.productService = productService;
        this.productMapper = productMapper;

        this.getProductUseCase = getProductUseCase;
        this.createProductUseCase = createProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
    }

    @Override
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> responseEntity = getProductUseCase.dispacth().block();
        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<model.Product> createProduct(@RequestBody model.Product product) {
        ProductEntity productEntityToCreate = productMapper.productApiToProduct(product);
        Product productCreated = createProductUseCase.dispacth(productEntityToCreate).block();
        return new ResponseEntity<>(productCreated, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<model.Product> updateProduct(@RequestBody model.Product product) {
        ProductEntity productEntityToUpdate = productMapper.productApiToProduct(product);
        Product productCreated = updateProductUseCase.dispacth(productEntityToUpdate).block();
        return new ResponseEntity<>(productCreated, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteProduct(@PathVariable("name") String name) {
        deleteProductUseCase.dispacth(name).block();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

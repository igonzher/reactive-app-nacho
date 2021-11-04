package com.nacho.app.controller.mapper;


import com.nacho.app.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapperController {

    Product productToProduct(Product target);
    @Mapping(target = "id", ignore = true)
    Product productToProduct(@MappingTarget Product target, Product source);

    model.Product productToProductApi(Product source);
    Product productApiToProduct(model.Product source);
}

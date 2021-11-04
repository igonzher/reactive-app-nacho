package com.nacho.app.repository.mapper;


import com.nacho.app.model.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity productToProduct(ProductEntity target);
    @Mapping(target = "id", ignore = true)
    ProductEntity productToProduct(@MappingTarget ProductEntity target, ProductEntity source);

    model.Product productToProductApi(ProductEntity source);
    ProductEntity productApiToProduct(model.Product source);
}

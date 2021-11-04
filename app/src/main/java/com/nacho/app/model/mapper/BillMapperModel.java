package com.nacho.app.model.mapper;


import com.nacho.app.model.Bill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BillMapperModel {

    Bill billToBill(Bill target);
    @Mapping(target = "id", ignore = true)
    Bill billToBill(@MappingTarget Bill target, Bill source);

    model.Bill billToBillApi(Bill source);
    Bill billApiToBill(model.Bill source);
}

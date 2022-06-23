package com.example.ordermanagement.mapper;

import com.example.ordermanagement.entity.OrderEntity;
import com.example.ordermanagement.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toModel(OrderEntity orderEntity);
    OrderEntity toEntity(Order order);

}

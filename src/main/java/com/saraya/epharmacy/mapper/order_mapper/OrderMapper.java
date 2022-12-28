package com.saraya.epharmacy.mapper.order_mapper;

import com.saraya.epharmacy.dto.order_dto.OrderDto;
import com.saraya.epharmacy.mapper.EntityMapper;
import com.saraya.epharmacy.modele.order_modele.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderMapper implements EntityMapper<OrderDto, Order> {
    @Override
    public Order toEntity(OrderDto dto) {
        Order order = new Order();
        order.setTotalPay(dto.getTotalPay());
        order.setPatient(dto.getPatient());
        order.setId(dto.getId());
        return order;
    }

    @Override
    public OrderDto toDto(Order entity) {
        OrderDto dto = new OrderDto();
        dto.setTotalPay(entity.getTotalPay());
        dto.setPatient(entity.getPatient());
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public List<Order> toEntityList(List<OrderDto> dtos) {
        List<Order> orders = new ArrayList<>();
        for (OrderDto dto : dtos) {
            orders.add(toEntity(dto));
        }
        return orders;
    }

    @Override
    public List<OrderDto> toDto(List<Order> entitys) {
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : entitys) {
            orderDtos.add(toDto(order));
        }
        return orderDtos;
    }
}

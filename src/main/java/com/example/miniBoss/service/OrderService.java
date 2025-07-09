package com.example.miniBoss.service;


import com.example.miniBoss.dto.OrderRequestDto;
import com.example.miniBoss.dto.OrderResponseDto;
import com.example.miniBoss.entity.OrderEntity;
import com.example.miniBoss.entity.OrderStatus;
import com.example.miniBoss.mapper.OrderMapper;
import com.example.miniBoss.repository.ClientRepository;
import com.example.miniBoss.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ClientRepository clientRepository;

    public OrderResponseDto addOrder( OrderRequestDto orderRequestDto) {
        OrderEntity orderEntity = orderMapper.toEntity(orderRequestDto);
        orderEntity.setDate(LocalDateTime.now());
        orderEntity.setClient(
                clientRepository.findById(orderRequestDto.getClientId())
                        .orElseThrow(() -> new RuntimeException("No client"))
        );
        return orderMapper.toResponse(orderRepository.save(orderEntity));
    }
    public OrderResponseDto updateOrder(int id, OrderStatus status) {
        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No order found"));
        orderEntity.setOrderStatus(status);
        return orderMapper.toResponse(orderRepository.save(orderEntity));
    }
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
    public Page<OrderResponseDto> getOrders(Pageable pageable) {
        return orderRepository.findAll(pageable).map(orderMapper::toResponse);
    }
    public OrderResponseDto getOrder(int id) {
        return orderRepository.findById(id).map(orderMapper::toResponse).orElse(null);
    }

}

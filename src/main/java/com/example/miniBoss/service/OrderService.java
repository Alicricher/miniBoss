package com.example.miniBoss.service;


import com.example.miniBoss.dto.OrderItemRequestDto;
import com.example.miniBoss.dto.OrderItemResponseDto;
import com.example.miniBoss.dto.OrderRequestDto;
import com.example.miniBoss.dto.OrderResponseDto;
import com.example.miniBoss.entity.OrderEntity;
import com.example.miniBoss.entity.OrderItem;
import com.example.miniBoss.entity.OrderStatus;
import com.example.miniBoss.entity.ProductEntity;
import com.example.miniBoss.mapper.OrderItemMapper;
import com.example.miniBoss.mapper.OrderMapper;
import com.example.miniBoss.repository.ClientRepository;
import com.example.miniBoss.repository.OrderItemRepository;
import com.example.miniBoss.repository.OrderRepository;
import com.example.miniBoss.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

    public void addProductsToOrder(int orderId, List<OrderItemRequestDto> productRequests) {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));

        for (OrderItemRequestDto dto : productRequests) {
            ProductEntity product = productRepository.findById(dto.getProductId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found"));

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(product);
            item.setQuantity(dto.getQuantity());

            orderItemRepository.save(item);
        }
    }


    public void updateOrderItem(int itemId, int newQuantity) {
        OrderItem item = orderItemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Order item not found"));

        item.setQuantity(newQuantity);
        orderItemRepository.save(item);
    }


    public void deleteOrderItem(int itemId) {
        if (!orderItemRepository.existsById(itemId)) {
            throw new EntityNotFoundException("Order item not found");
        }
        orderItemRepository.deleteById(itemId);
    }


    public List<OrderItemResponseDto> getOrderItems(int orderId) {
        List<OrderItem> items = orderItemRepository.findByOrderId(orderId);
        return items.stream()
                .map(orderItemMapper::toDto)
                .toList();
    }

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
        return orderRepository.findById(id).map(orderMapper::toResponse).orElseThrow(() -> new RuntimeException("No order found"));
    }

}

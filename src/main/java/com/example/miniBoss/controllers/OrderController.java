package com.example.miniBoss.controllers;

import com.example.miniBoss.dto.OrderItemRequestDto;
import com.example.miniBoss.dto.OrderItemResponseDto;
import com.example.miniBoss.dto.OrderRequestDto;
import com.example.miniBoss.dto.OrderResponseDto;
import com.example.miniBoss.entity.OrderStatus;
import com.example.miniBoss.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{orderId}/items")
    public ResponseEntity<Void> addItems(@PathVariable int orderId,
                                         @RequestBody List<OrderItemRequestDto> items) {
        orderService.addProductsToOrder(orderId, items);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/items/{itemId}")
    public ResponseEntity<Void> updateItem(@PathVariable int itemId,
                                           @RequestParam int quantity) {
        orderService.updateOrderItem(itemId, quantity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable int itemId) {
        orderService.deleteOrderItem(itemId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{orderId}/items")
    public ResponseEntity<List<OrderItemResponseDto>> getItems(@PathVariable int orderId) {
        return ResponseEntity.ok(orderService.getOrderItems(orderId));
    }

    @PostMapping
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto dto) {
        return orderService.addOrder(dto);
    }


    @PatchMapping("/{id}/status")
    public OrderResponseDto updateOrderStatus(
            @PathVariable int id,
            @RequestParam OrderStatus status
    ) {
        return orderService.updateOrder(id, status);
    }


    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }


    @GetMapping("/{id}")
    public OrderResponseDto getOrder(@PathVariable int id) {
        return orderService.getOrder(id);
    }


    @GetMapping
    public Page<OrderResponseDto> getOrders(Pageable pageable) {
        return orderService.getOrders(pageable);
    }
}

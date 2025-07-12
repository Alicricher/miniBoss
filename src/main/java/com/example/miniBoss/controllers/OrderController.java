package com.example.miniBoss.controllers;

import com.example.miniBoss.dto.OrderRequestDto;
import com.example.miniBoss.dto.OrderResponseDto;
import com.example.miniBoss.entity.OrderStatus;
import com.example.miniBoss.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    // Создание заказа
    @PostMapping
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto dto) {
        return orderService.addOrder(dto);
    }

    // Обновление статуса заказа
    @PatchMapping("/{id}/status")
    public OrderResponseDto updateOrderStatus(
            @PathVariable int id,
            @RequestParam OrderStatus status
    ) {
        return orderService.updateOrder(id, status);
    }

    // Удаление заказа
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }

    // Получение одного заказа
    @GetMapping("/{id}")
    public OrderResponseDto getOrder(@PathVariable int id) {
        return orderService.getOrder(id);
    }

    // Получение списка заказов с фильтрацией по статусу, пагинацией и сортировкой
    @GetMapping
    public Page<OrderResponseDto> getOrders(Pageable pageable) {
        return orderService.getOrders(pageable);
    }
}

package com.example.miniBoss.controllers;

import com.example.miniBoss.dto.ProductRequestDto;
import com.example.miniBoss.dto.ProductResponseDto;
import com.example.miniBoss.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.addProduct(productRequestDto);
    }

    @GetMapping("/products")
    public Page<ProductResponseDto> getAllProducts(Pageable pageable) {
        return productService.getAllProducts(pageable);
    }

    @GetMapping("/products/{id}")
    public ProductResponseDto getProduct(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProductById(id);
    }
    @PutMapping("/products/{id}")
    public ProductResponseDto updateProduct(@PathVariable int id, @RequestBody ProductRequestDto productRequestDto) {
        return productService.updateProductById(id, productRequestDto);
    }
}

package com.example.miniBoss.service;

import com.example.miniBoss.dto.ProductRequestDto;
import com.example.miniBoss.dto.ProductResponseDto;
import com.example.miniBoss.entity.ProductEntity;
import com.example.miniBoss.mapper.ProductMapper;
import com.example.miniBoss.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {
        ProductEntity productEntity = mapper.toEntity(productRequestDto);
        ProductEntity savedEntity = productRepository.save(productEntity);
        return mapper.toResponse(savedEntity);
    }
    public Page<ProductResponseDto> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable).map(mapper::toResponse);
    }
    public ProductResponseDto getProductById(Integer id) {
        return productRepository.findById(id).map(mapper::toResponse).orElseThrow(() -> new EntityNotFoundException("No such product" + id));
    }
    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    public ProductResponseDto updateProductById(int id, ProductRequestDto productRequestDto) {
        ProductEntity existingEntity = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No such product" + id));
        mapper.updateEntity(productRequestDto, existingEntity);
        ProductEntity savedEntity = productRepository.save(existingEntity);
        return mapper.toResponse(savedEntity);
    }
}

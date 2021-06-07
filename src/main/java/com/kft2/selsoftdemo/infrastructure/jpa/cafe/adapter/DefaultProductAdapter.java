package com.kft2.selsoftdemo.infrastructure.jpa.cafe.adapter;

import com.kft2.selsoftdemo.domain.cafe.model.Product;
import com.kft2.selsoftdemo.domain.cafe.repository.ProductAdapter;
import com.kft2.selsoftdemo.infrastructure.jpa.cafe.entity.ProductEntity;
import com.kft2.selsoftdemo.infrastructure.jpa.cafe.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultProductAdapter implements ProductAdapter {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public Product findById(Long id) {
        return productJpaRepository.findById(id).map(ProductEntity::toModel).orElseThrow(RuntimeException::new);
    }
}

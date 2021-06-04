package com.kft2.selsoftdemo.infrastructure.jpa.cafe.adapter;

import com.kft2.selsoftdemo.domain.cafe.model.Product;
import com.kft2.selsoftdemo.domain.cafe.repository.ProductRepository;
import com.kft2.selsoftdemo.infrastructure.jpa.cafe.entity.ProductEntity;
import com.kft2.selsoftdemo.infrastructure.jpa.cafe.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductAdapter implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public Product findById(Long id) {
        return productJpaRepository.findById(id).map(ProductEntity::toModel).orElseThrow(RuntimeException::new); //todo custom excp
    }
}

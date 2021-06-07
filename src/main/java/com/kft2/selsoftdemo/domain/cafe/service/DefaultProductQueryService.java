package com.kft2.selsoftdemo.domain.cafe.service;

import com.kft2.selsoftdemo.domain.cafe.model.Product;
import com.kft2.selsoftdemo.domain.cafe.repository.ProductAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultProductQueryService implements ProductQueryService {

    private final ProductAdapter productAdapter;

    @Override
    public Product findById(Long id) {
        return productAdapter.findById(id);
    }
}

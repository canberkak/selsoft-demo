package com.kft2.selsoftdemo.domain.cafe.service;

import com.kft2.selsoftdemo.domain.cafe.model.Product;
import com.kft2.selsoftdemo.domain.cafe.port.ProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultProductQueryService implements ProductQueryService {

    private final ProductPort productPort;

    @Override
    public Product findById(Long id) {
        return productPort.findById(id);
    }
}

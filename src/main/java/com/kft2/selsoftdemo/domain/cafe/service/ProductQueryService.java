package com.kft2.selsoftdemo.domain.cafe.service;

import com.kft2.selsoftdemo.domain.cafe.model.Product;

public interface ProductQueryService {

    Product findById(Long id);
}

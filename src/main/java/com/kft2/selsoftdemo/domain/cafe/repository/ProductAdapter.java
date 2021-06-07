package com.kft2.selsoftdemo.domain.cafe.repository;

import com.kft2.selsoftdemo.domain.cafe.model.Product;

public interface ProductAdapter {

    Product findById(Long id);

}

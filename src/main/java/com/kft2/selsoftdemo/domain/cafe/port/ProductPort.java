package com.kft2.selsoftdemo.domain.cafe.port;

import com.kft2.selsoftdemo.domain.cafe.model.Product;

public interface ProductPort {

    Product findById(Long id);

}

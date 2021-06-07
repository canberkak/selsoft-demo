package com.kft2.selsoftdemo.domain.cafe.repository;


import com.kft2.selsoftdemo.domain.cafe.model.Cafe;

import java.util.List;

public interface CafeAdapter {

    Cafe findById(Long id);

    List<Cafe> findAll();
}

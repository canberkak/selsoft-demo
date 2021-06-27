package com.kft2.selsoftdemo.application.service;

import com.kft2.selsoftdemo.domain.cafe.model.Cafe;

import java.util.List;

public interface CafeService {

    Cafe getCafeById(Long id);

    List<Cafe> getAll();
}

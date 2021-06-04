package com.kft2.selsoftdemo.domain.cafe.service;

import com.kft2.selsoftdemo.domain.cafe.model.Cafe;

import java.util.List;


public interface CafeQueryService {

    Cafe getCafeById(Long id);

    List<Cafe> getAll();


}

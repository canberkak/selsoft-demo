package com.kft2.selsoftdemo.application.service;

import com.kft2.selsoftdemo.domain.cafe.model.Cafe;
import com.kft2.selsoftdemo.domain.cafe.service.CafeQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DefaultCafeService implements CafeService {

    private final CafeQueryService cafeQueryService;

    @Override
    public Cafe getCafeById(Long id) {
        return cafeQueryService.getCafeById(id);
    }

    @Override
    public List<Cafe> getAll() {
        return cafeQueryService.getAll();
    }
}

package com.kft2.selsoftdemo.domain.cafe.service;

import com.kft2.selsoftdemo.domain.cafe.model.Cafe;
import com.kft2.selsoftdemo.domain.cafe.repository.CafeAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultCafeQueryService implements CafeQueryService {

    private final CafeAdapter cafeAdapter;

    @Override
    public Cafe getCafeById(Long id) {
        return cafeAdapter.findById(id);
    }

    @Override
    public List<Cafe> getAll() {
        return cafeAdapter.findAll();
    }


}

package com.kft2.selsoftdemo.domain.cafe.service;

import com.kft2.selsoftdemo.domain.cafe.model.Cafe;
import com.kft2.selsoftdemo.domain.cafe.port.CafePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultCafeQueryService implements CafeQueryService {

    private final CafePort cafePort;

    @Override
    public Cafe getCafeById(Long id) {
        return cafePort.findById(id);
    }

    @Override
    public List<Cafe> getAll() {
        return cafePort.findAll();
    }


}

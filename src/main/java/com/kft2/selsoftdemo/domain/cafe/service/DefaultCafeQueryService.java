package com.kft2.selsoftdemo.domain.cafe.service;

import com.kft2.selsoftdemo.domain.cafe.model.Cafe;
import com.kft2.selsoftdemo.domain.cafe.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultCafeQueryService implements CafeQueryService {

    private final CafeRepository cafeRepository;

    @Override
    public Cafe getCafeById(Long id) {
        return cafeRepository.findById(id);
    }

    @Override
    public List<Cafe> getAll() {
        return cafeRepository.findAll();
    }


}

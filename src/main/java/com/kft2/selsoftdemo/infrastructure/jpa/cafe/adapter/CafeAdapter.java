package com.kft2.selsoftdemo.infrastructure.jpa.cafe.adapter;

import com.kft2.selsoftdemo.domain.cafe.model.Cafe;
import com.kft2.selsoftdemo.domain.cafe.repository.CafeRepository;
import com.kft2.selsoftdemo.infrastructure.jpa.cafe.entity.CafeEntity;
import com.kft2.selsoftdemo.infrastructure.jpa.cafe.repository.CafeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CafeAdapter implements CafeRepository {

    private final CafeJpaRepository cafeJpaRepository;

    @Override
    public Cafe findById(Long id) {
        return cafeJpaRepository.findById(id).map(CafeEntity::toModel).orElseThrow(RuntimeException::new); //todo custom excp
    }

    @Override
    public List<Cafe> findAll() {
        return cafeJpaRepository.findAll().stream().map(CafeEntity::toModel).collect(Collectors.toList());
    }


}

package com.kft2.selsoftdemo.domain.cafe.port;


import com.kft2.selsoftdemo.domain.cafe.model.Cafe;

import java.util.List;

public interface CafePort {

    Cafe findById(Long id);

    List<Cafe> findAll();
}

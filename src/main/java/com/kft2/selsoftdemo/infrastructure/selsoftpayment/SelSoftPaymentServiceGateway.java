package com.kft2.selsoftdemo.infrastructure.selsoftpayment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class SelSoftPaymentServiceGateway implements SelsoftPaymentService {

    @Override
    public void order(String accountEmail, BigDecimal price) {
        log.info("selsoft order completed");
    }
}

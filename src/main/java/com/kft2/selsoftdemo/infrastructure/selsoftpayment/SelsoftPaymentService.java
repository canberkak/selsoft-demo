package com.kft2.selsoftdemo.infrastructure.selsoftpayment;

import java.math.BigDecimal;

public interface SelsoftPaymentService {

    void order(String accountEmail, BigDecimal price);
}

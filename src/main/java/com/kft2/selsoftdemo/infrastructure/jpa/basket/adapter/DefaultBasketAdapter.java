package com.kft2.selsoftdemo.infrastructure.jpa.basket.adapter;

import com.kft2.selsoftdemo.domain.basket.model.Basket;
import com.kft2.selsoftdemo.domain.basket.model.type.BasketStatus;
import com.kft2.selsoftdemo.domain.basket.repository.BasketAdapter;
import com.kft2.selsoftdemo.infrastructure.jpa.basket.entity.BasketEntity;
import com.kft2.selsoftdemo.infrastructure.jpa.basket.repository.BasketJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultBasketAdapter implements BasketAdapter {

    private final BasketJpaRepository basketJpaRepository;

    @Override
    public Basket findByAccountId(Long accountId) {
        return basketJpaRepository.findByAccountIdAndBasketStatus(accountId, BasketStatus.ACTIVE)
                .orElseGet(() -> createBasket(accountId)).toModel();
    }

    private BasketEntity createBasket(Long accountId) {
        BasketEntity basketEntity = new BasketEntity();
        basketEntity.setAccountId(accountId);
        return basketJpaRepository.save(basketEntity);
    }


    @Override
    public Basket findById(Long id) {
        return basketJpaRepository.findById(id).orElseThrow(RuntimeException::new).toModel();
    }

    @Override
    public void save(Basket basket) {
        var basketEntity = basketJpaRepository.findById(basket.getId()).orElseThrow(RuntimeException::new);
        basketEntity.setTotalPrice(basket.getTotalPrice());
        basketEntity.setBasketStatus(basket.getBasketStatus());
        basketJpaRepository.save(basketEntity);
    }
}

package com.kft2.selsoftdemo.infrastructure.jpa.basket.adapter;

import com.kft2.selsoftdemo.domain.basket.model.BasketItem;
import com.kft2.selsoftdemo.domain.basket.repository.BasketItemAdapter;
import com.kft2.selsoftdemo.infrastructure.jpa.basket.entity.BasketItemEntity;
import com.kft2.selsoftdemo.infrastructure.jpa.basket.repository.BasketItemJpaRepository;
import com.kft2.selsoftdemo.infrastructure.jpa.basket.repository.BasketJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class DefaultBasketItemAdapter implements BasketItemAdapter {

    private final BasketItemJpaRepository basketItemJpaRepository;
    private final BasketJpaRepository basketJpaRepository;

    @Override
    public BasketItem findByBasketIdAndProductId(Long basketId, Long productId) {
        var basketItemEntity = basketItemJpaRepository.findByBasketIdAndProductId(basketId, productId);
        if (basketItemEntity.isPresent()) {
            return basketItemEntity.get().toModel();
        }
        return createBasketItem(basketId, productId).toModel();
    }

    public BasketItemEntity createBasketItem(Long basketId, Long productId) {
        BasketItemEntity basketItemEntity = new BasketItemEntity();
        var basketEntity = basketJpaRepository.findById(basketId).orElseThrow(RuntimeException::new);
        basketItemEntity.setBasket(basketEntity);
        basketItemEntity.setProductId(productId);
        return basketItemJpaRepository.save(basketItemEntity);
    }

    @Override
    public void save(BasketItem basketItem) {
        var basketItemEntity = basketItemJpaRepository.findById(basketItem.getId()).orElseThrow(RuntimeException::new);
        basketItemEntity.setQuantity(basketItem.getQuantity());
        basketItemEntity.setTotalPrice(basketItem.getTotalPrice());
        basketItemJpaRepository.save(basketItemEntity);
    }

    @Override
    public void remove(BasketItem basketItem) {
        var basketItemEntity = basketItemJpaRepository.findById(basketItem.getId()).orElseThrow(RuntimeException::new);
        basketItemJpaRepository.delete(basketItemEntity);
    }

    @Override
    public List<BasketItem> findByBasketId(Long basketId) {
        return basketItemJpaRepository.findByBasketId(basketId).stream().map(BasketItemEntity::toModel).collect(Collectors.toList());
    }

    @Override
    public BasketItem findById(Long basketItemId) {
        return basketItemJpaRepository.findById(basketItemId).orElseThrow(RuntimeException::new).toModel();
    }
}

package com.kft2.selsoftdemo.infrastructure.jpa.basket.adapter;

import com.kft2.selsoftdemo.domain.basket.model.BasketItem;
import com.kft2.selsoftdemo.domain.basket.repository.BasketItemRepository;
import com.kft2.selsoftdemo.infrastructure.jpa.basket.entity.BasketItemEntity;
import com.kft2.selsoftdemo.infrastructure.jpa.basket.repository.BasketItemJpaRepository;
import com.kft2.selsoftdemo.infrastructure.jpa.basket.repository.BasketJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BasketItemAdapter implements BasketItemRepository {

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
        basketItemEntity.setBasket(basketJpaRepository.findById(basketId).get());
        basketItemEntity.setProductId(productId);
        return basketItemJpaRepository.save(basketItemEntity);
    }

    @Override
    public void save(BasketItem basketItem) {
        /**
         *  todo
         *  Id setleyip tekrar entity için repo isteği atmayı engelleyebiliriz ?
         *  Null check istiyor ama gereksiz. (BasketItem yoksa oluşturuyor method öncesi)
         */
        var basketItemEntity = basketItemJpaRepository.findById(basketItem.getId()).get();
        basketItemEntity.setQuantity(basketItem.getQuantity());
        basketItemEntity.setTotalPrice(basketItem.getTotalPrice());
        basketItemJpaRepository.save(basketItemEntity);
    }

    @Override
    public List<BasketItem> findByBasketId(Long basketId) {
        return basketItemJpaRepository.findByBasketId(basketId).stream().map(BasketItemEntity::toModel).collect(Collectors.toList());
    }
}

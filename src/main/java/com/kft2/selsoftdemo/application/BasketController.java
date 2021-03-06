package com.kft2.selsoftdemo.application;

import com.kft2.selsoftdemo.application.mapper.BasketMapper;
import com.kft2.selsoftdemo.application.request.AddItemToBasketRequest;
import com.kft2.selsoftdemo.application.response.BasketResponse;
import com.kft2.selsoftdemo.application.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/basket")
public class BasketController {

    private final BasketService basketService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<BasketResponse> getActiveBasket(HttpServletRequest httpServletRequest) {
        var basketResponse = BasketMapper.basketToBasketResponse(basketService.getBasketByToken(httpServletRequest));
        return new ResponseEntity<>(basketResponse,HttpStatus.OK);
    }

    @PostMapping("/add-item")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> addItemToBasket(HttpServletRequest httpServletRequest,
                                             @RequestBody @Valid AddItemToBasketRequest addItemToBasketRequest) {
        basketService.addItemToBasket(httpServletRequest, addItemToBasketRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/remove-item/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> removeItemFromBasket(HttpServletRequest httpServletRequest,
                                                  @PathVariable("id") Long id) {
        basketService.removeItemFromBasket(httpServletRequest, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/order")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> order(HttpServletRequest httpServletRequest) {
        basketService.orderBasket(httpServletRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.kft2.selsoftdemo.application;

import com.kft2.selsoftdemo.application.mapper.CafeMapper;
import com.kft2.selsoftdemo.application.response.CafeResponse;
import com.kft2.selsoftdemo.domain.cafe.service.CafeCommandService;
import com.kft2.selsoftdemo.domain.cafe.service.CafeQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/cafe")
public class CafeController {

    private final CafeQueryService cafeQueryService;

    @GetMapping("/{id}")
    public ResponseEntity<CafeResponse> getCafeById(@PathVariable("id") Long id) {
        var cafeResponse = CafeMapper.cafeToCafeResponse(cafeQueryService.getCafeById(id));
        return new ResponseEntity<>(cafeResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CafeResponse>> getAll() {
        var cafeResponseList = CafeMapper.cafeListToCafeResponseList(cafeQueryService.getAll());
        return new ResponseEntity<>(cafeResponseList, HttpStatus.OK);
    }


}

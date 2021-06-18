package com.kft2.selsoftdemo.application.mapper;

public interface Mapper<S, T> {

    T map(S source);
}

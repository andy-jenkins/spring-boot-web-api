package com.samples.springbootwebapi.integration;

import com.samples.springbootwebapi.application.model.CarDto;

import java.util.List;
import java.util.UUID;

public interface CarRepository {

    void add(CarDto car);

    List<CarDto> findAll();

    CarDto getById(UUID id);

    void removeById(UUID id);
}

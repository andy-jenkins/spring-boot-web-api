package com.samples.springbootwebapi.integration;

import com.samples.springbootwebapi.application.exception.ResourceNotFoundException;
import com.samples.springbootwebapi.application.model.CarDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class InMemoryCarRepository implements CarRepository {

    public InMemoryCarRepository() {
        cars = new ArrayList<>();
    }

    @Override
    public void add(CarDto car) {
        cars.add(car);
    }

    @Override
    public List<CarDto> findAll() {
        return cars;
    }

    @Override
    public CarDto getById(UUID id) {
        return cars
                .stream()
                .filter(car -> car.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "CarDto with id '" + id.toString() + "' was not found"));
    }

    @Override
    public void removeById(UUID id) {
        CarDto car = getById(id);
        cars.remove(car);
    }

    private List<CarDto> cars;
}

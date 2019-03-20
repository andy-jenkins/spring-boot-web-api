package com.samples.springbootwebapi.controller;

import com.samples.springbootwebapi.application.model.CarDto;
import com.samples.springbootwebapi.integration.CarRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cars")
public class CarsController {

    private final CarRepository carRepository;

    @Autowired
    public CarsController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @ApiOperation(value = "List all cars.")
    @GetMapping
    public List<CarDto> list() {
        return carRepository.findAll();
    }

    @ApiOperation(value = "Create a new car.")
    @PostMapping
    public CarDto create(@RequestBody CarDto car) {
        carRepository.add(car);
        return carRepository.getById(car.getId());
    }

    @ApiOperation(value = "Get the current representation of a car.")
    @GetMapping("/{id}")
    public CarDto get(@PathVariable UUID id) {
        return carRepository.getById(id);
    }

    @ApiOperation(value = "Scrap a car.")
    @DeleteMapping("/{id}")
    public void scrap(@PathVariable UUID id) {
        carRepository.removeById(id);
    }
}

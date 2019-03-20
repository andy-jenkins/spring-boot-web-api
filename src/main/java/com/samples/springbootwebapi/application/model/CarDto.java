package com.samples.springbootwebapi.application.model;

import java.util.UUID;

public class CarDto {

    private UUID id;

    private String make;
    private String model;

    public CarDto() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

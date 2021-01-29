package com.sixt.sixtfront.form;

public class VehicleForm {

    private Integer id;
    private String licensePlate;
    private String type;
    private String brand;
    private String model;
    private String color;
    private Float rentPrice;
    private Float kilometerPrice;
    private Integer horsePower;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Float rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Float getKilometerPrice() {
        return kilometerPrice;
    }

    public void setKilometerPrice(Float kilometerPrice) {
        this.kilometerPrice = kilometerPrice;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

}

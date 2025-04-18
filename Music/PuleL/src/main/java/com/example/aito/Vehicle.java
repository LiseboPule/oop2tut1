package com.example.aito;

import javafx.beans.property.*;

public class Vehicle {
    private final StringProperty vehicleId;
    private final StringProperty brand;
    private final StringProperty category;
    private final DoubleProperty pricePerDay;
    private final StringProperty status;

    public Vehicle(String vehicleId, String brand, String category, double pricePerDay, String status) {
        this.vehicleId = new SimpleStringProperty(vehicleId);
        this.brand = new SimpleStringProperty(brand);
        this.category = new SimpleStringProperty(category);
        this.pricePerDay = new SimpleDoubleProperty(pricePerDay);
        this.status = new SimpleStringProperty(status);
    }

    public String getVehicleId() { return vehicleId.get(); }
    public StringProperty vehicleIdProperty() { return vehicleId; }

    public String getBrand() { return brand.get(); }
    public StringProperty brandProperty() { return brand; }

    public String getCategory() { return category.get(); }
    public StringProperty categoryProperty() { return category; }

    public double getPricePerDay() { return pricePerDay.get(); }
    public DoubleProperty pricePerDayProperty() { return pricePerDay; }

    public String getStatus() { return status.get(); }
    public StringProperty statusProperty() { return status; }
}

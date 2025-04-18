package com.example.aito;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class VehicleManagementController {

    @FXML
    private TextField searchField;

    @FXML
    private Button searchBtn, backToDashboardBtn, addBtn, updateBtn, deleteBtn;

    @FXML
    private TableView<Vehicle> tableView;

    @FXML
    private TableColumn<Vehicle, String> vehicleIdCol;

    @FXML
    private TableColumn<Vehicle, String> brandCol;

    @FXML
    private TableColumn<Vehicle, String> categoryCol;

    @FXML
    private TableColumn<Vehicle, Double> priceCol;

    @FXML
    private TableColumn<Vehicle, String> statusCol;

    private final ObservableList<Vehicle> vehicleList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind the table columns to the Vehicle class
        vehicleIdCol.setCellValueFactory(data -> data.getValue().vehicleIdProperty());
        brandCol.setCellValueFactory(data -> data.getValue().brandProperty());
        categoryCol.setCellValueFactory(data -> data.getValue().categoryProperty());
        priceCol.setCellValueFactory(data -> data.getValue().pricePerDayProperty().asObject());
        statusCol.setCellValueFactory(data -> data.getValue().statusProperty());

        // Sample data
        vehicleList.add(new Vehicle("001", "Lamborgini Huracan", "Sports Car", 900, "Available"));
        vehicleList.add(new Vehicle("002", "Audi A4", "Luxury", 600, "Booked"));
        vehicleList.add(new Vehicle("003", "Toyota Yaris", "Hatchback", 600, "Booked"));
        vehicleList.add(new Vehicle("004", "Audi Q7", "SUV", 600, "Booked"));
        vehicleList.add(new Vehicle("005", "BMW M3", "Sports", 600, "Booked"));

        tableView.setItems(vehicleList);
    }

    @FXML
    private void onSearch(ActionEvent event) {
        String keyword = searchField.getText().toLowerCase();
        ObservableList<Vehicle> filteredList = FXCollections.observableArrayList();

        for (Vehicle v : vehicleList) {
            if (v.getBrand().toLowerCase().contains(keyword) || v.getVehicleId().toLowerCase().contains(keyword)) {
                filteredList.add(v);
            }
        }

        tableView.setItems(filteredList);
    }

    @FXML
    private void onAdd(ActionEvent event) {
        System.out.println("Add button clicked");
        // Add functionality here
    }

    @FXML
    private void onUpdate(ActionEvent event) {
        System.out.println("Update button clicked");
        // Update functionality here
    }

    @FXML
    private void onDelete(ActionEvent event) {
        System.out.println("Delete button clicked");
        // Delete functionality here
    }

    @FXML
    private void onBackToDashboard(ActionEvent event) {
        System.out.println("Back to Dashboard clicked");
        // Scene switching code goes here
    }
}

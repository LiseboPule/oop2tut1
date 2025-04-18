package com.example.aito;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

import java.io.IOException;

public class DashboardController {

    @FXML private Label welcomeLabel;
    @FXML private Label vehiclesCountLabel;
    @FXML private Label availableCountLabel;
    @FXML private Label bookedCountLabel;
    @FXML private Label maintenanceCountLabel;
    @FXML private Label totalBookingsLabel;
    @FXML private Label pendingBookingsLabel;
    @FXML private Label activeBookingsLabel;
    @FXML private Label completedBookingsLabel;
    @FXML private PieChart vehicleStatusChart;
    @FXML private BarChart<String, Number> bookingStatusChart;

    private String username;

    public void setUsername(String username) {
        this.username = username;
        welcomeLabel.setText("Welcome, " + username + "!");
    }

    @FXML
    public void initialize() {
        // Sample data
        vehiclesCountLabel.setText("12");
        availableCountLabel.setText("8");
        bookedCountLabel.setText("3");
        maintenanceCountLabel.setText("1");

        totalBookingsLabel.setText("25");
        pendingBookingsLabel.setText("5");
        activeBookingsLabel.setText("15");
        completedBookingsLabel.setText("5");

        // Populate PieChart
        vehicleStatusChart.setData(FXCollections.observableArrayList(
                new PieChart.Data("Available", 8),
                new PieChart.Data("Booked", 3),
                new PieChart.Data("Maintenance", 1)
        ));

        // Populate BarChart
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Pending", 5));
        series.getData().add(new XYChart.Data<>("Active", 15));
        series.getData().add(new XYChart.Data<>("Completed", 5));
        bookingStatusChart.getData().add(series);
    }

    @FXML
    public void handleLogout(ActionEvent event) {
        showAlert("Logout", "You have successfully logged out.");
    }

    @FXML
    public void navigateToDashboard(ActionEvent event) {
        System.out.println("Dashboard clicked");
    }

    @FXML
    public void navigateToVehicles(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/aito/vehicle-management.fxml"));
            Parent vehicleManagementRoot = fxmlLoader.load();

            Stage currentStage = (Stage) welcomeLabel.getScene().getWindow();
            Scene newScene = new Scene(vehicleManagementRoot);
            currentStage.setScene(newScene);
            currentStage.setTitle("Vehicle Management");
        } catch (IOException e) {
            showAlert("Error", "Failed to load Vehicle Management view.");
            e.printStackTrace();
        }
    }

    @FXML
    public void navigateToBookings(ActionEvent event) {
        System.out.println("Bookings clicked");
    }

    @FXML
    public void navigateToCustomers(ActionEvent event) {
        System.out.println("Customers clicked");
    }

    @FXML
    public void navigateToReports(ActionEvent event) {
        System.out.println("Reports clicked");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
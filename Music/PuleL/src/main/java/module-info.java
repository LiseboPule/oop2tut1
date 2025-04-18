module com.example.aito {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aito to javafx.fxml;
    exports com.example.aito;
}
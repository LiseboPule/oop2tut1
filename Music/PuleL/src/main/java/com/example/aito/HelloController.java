package com.example.aito;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private CheckBox admincheckbox;

    @FXML
    private AnchorPane ancorpanename;

    @FXML
    private CheckBox employeecheckbox;

    @FXML
    private Button loginbtn;

    @FXML
    private Text nmtxt;

    @FXML
    private Pane pane;

    @FXML
    private Pane pn;

    @FXML
    private Text pswdtxt;

    @FXML
    private Text sntxt;

    @FXML
    private Text srtxt;

    @FXML
    private TextField textfieldname;

    @FXML
    private PasswordField textfieldpassword;

    @FXML
    private TextField textfieldsurname;

    @FXML
    private void handleLoginButtonAction() {
        String name = textfieldname.getText().trim();
        String surname = textfieldsurname.getText().trim();
        String password = textfieldpassword.getText().trim();
        boolean isAdmin = admincheckbox.isSelected();
        boolean isEmployee = employeecheckbox.isSelected();

        if (name.isEmpty() || surname.isEmpty() || password.isEmpty()) {
            System.out.println("Please fill in all fields.");
            return;
        }

        if ((isAdmin && isEmployee) || (!isAdmin && !isEmployee)) {
            System.out.println("Please select either Admin or Employee, not both.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Parent dashboardRoot = loader.load();
            Scene dashboardScene = new Scene(dashboardRoot);
            Stage stage = (Stage) loginbtn.getScene().getWindow();
            stage.setScene(dashboardScene);
            stage.setTitle("Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.manageData.ManageStaffFile;

import java.io.IOException;

public class ForgetPassword {
    @FXML private TextField usernameField;
    @FXML private PasswordField newPasswordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Button previousButton;
    @FXML private Button newPasswordButton;

    @FXML public void initialize(){

    }
    @FXML public void handlePreviousButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/...fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        LoginSuccessGuest l = loader.getController();
        stage.show();
    }
    @FXML public void handleNewPasswordButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/...fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        LoginSuccessGuest l = loader.getController();
        stage.show();
    }
}

package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterStaff {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Button previousButton;
    @FXML private Button newAccountButton;

    @FXML public void handlePreviousButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/login_success_admin.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        LoginSuccessAdmin l = loader.getController();
        stage.show();
    }
    @FXML public void handleNewAccountButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/login_success_admin.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        LoginSuccessAdmin l = loader.getController();
        stage.show();
    }
}

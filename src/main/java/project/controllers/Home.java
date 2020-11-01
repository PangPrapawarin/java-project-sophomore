package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Home {
    @FXML private Button loginStaffButton;
    @FXML private Button loginGuestButton;
    @FXML private Button loginAdminButton;
    @FXML private Button infoButton;
    @FXML private Button producerButton;

    @FXML public void handleLoginStaffButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/login_staff.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        LoginStaff l = loader.getController();
        stage.show();
    }
    @FXML public void handleLoginAdminButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/login_admin.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        LoginAdmin l = loader.getController();
        stage.show();
    }
    @FXML public void handleLoginGuestButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/login_guest.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        LoginGuest l = loader.getController();
        stage.show();
    }
    @FXML public void handleRecommendButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/popup_recommend.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        PopUpRecommend l = loader.getController();
        stage.show();
    }
    @FXML public void handleInfoNisitButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/popup_nisit.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        PopUpNisit l = loader.getController();
        stage.show();
    }
}

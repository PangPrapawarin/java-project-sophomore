package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class NewManage {
    @FXML private Button newMailButton;
    @FXML private Button newDocumentButton;
    @FXML private Button newThingsButton;
    @FXML private Button previousButton;
    @FXML private Button logoutButton;

    @FXML public void handleNewMailButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/new_mail.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        NewMail l = loader.getController();
        stage.show();
    }
    @FXML public void handleNewDocumentButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/new_document.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        NewDocument l = loader.getController();
        stage.show();
    }
    @FXML public void handleNewThingsButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/new_supply.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        NewSupply l = loader.getController();
        stage.show();
    }
    @FXML public void handlePreviousButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/manage.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        Manage l = loader.getController();
        stage.show();
    }
    @FXML public void handleLogoutButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/home.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        Home l = loader.getController();
        stage.show();
    }
}

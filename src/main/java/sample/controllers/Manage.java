package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class Manage {
    @FXML private ChoiceBox sort;
    @FXML private TableView manageTable;
    @FXML private Button newManageButton;
    @FXML private Button successReceiveButton;
    @FXML private Button previousButton;
    @FXML private Button logoutButton;

    @FXML public void handleNewManageButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/new_manage.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        NewManage l = loader.getController();
        stage.show();
    }
    @FXML public void handleSuccessReceiveButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/success_receive.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        SuccessReceive l = loader.getController();
        stage.show();
    }
    @FXML public void handlePreviousButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/login_success_staff.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        LoginSuccessStaff l = loader.getController();
        stage.show();
    }
    @FXML public void handleLogoutButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/home.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        Home l = loader.getController();
        stage.show();
    }
}

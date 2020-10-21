package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import sample.manageData.ManageFile;

import java.io.IOException;

public class LoginSuccessAdmin {
    @FXML private TableView staffTable;
    @FXML private Button newStaffAccountButton;
    @FXML private Button logoutButton;

    @FXML public void initialize(){
        ManageFile staffData = new ManageFile("data", "staffAccount.csv");
    }
    @FXML public void handleNewStaffAccountButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/register_staff.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        RegisterStaff l = loader.getController();
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

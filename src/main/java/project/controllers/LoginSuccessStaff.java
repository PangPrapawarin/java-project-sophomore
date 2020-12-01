package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import project.manageData.ManageStaffFile;
import project.models.AdminList;
import project.models.StaffAccount;

import java.io.IOException;

public class LoginSuccessStaff {
    private AdminList staffList; //polymorphism
    private ManageStaffFile staffData;

    @FXML private Label username;
    @FXML private Label name;
    @FXML private Button detailRoomButton;
    @FXML private Button manageButton;
    @FXML private Button logoutButton;

    @FXML public void initialize() throws IOException{
        staffData = new ManageStaffFile("data", "staffAccount.csv");
        staffList = staffData.getList();
    }
    @FXML public void setNameStaff(String usernameText, String nameText) throws IOException {
        username.setText(usernameText);
        name.setText(nameText);
    }
    @FXML public void handleManageButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/manage.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        Manage l = loader.getController();
        stage.show();
    }
    @FXML public void handleDetailRoomButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/detail_room.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        DetailRoom l = loader.getController();
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

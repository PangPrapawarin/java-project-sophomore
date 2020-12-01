package project.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import project.manageData.ManageGuestFile;
import project.manageData.ManageStaffFile;
import project.models.AdminList;
import project.models.GuestAccount;

import java.io.IOException;

public class LoginSuccessGuest {
    private AdminList guestList; //polymorphism
    private String nameGuest;
    private String usernameGuest;
    private LoginGuest guest;
    private ManageStaffFile guestFile; //polymorphism

    @FXML private Label username;
    @FXML private Label name;
    @FXML private Button successReceiveButton;
    @FXML private Button logoutButton;

    @FXML
    public void initialize() {
        Platform.runLater((Runnable)new Runnable() {
            @Override
            public void run() {
                guestFile = new ManageGuestFile("data", "guestAccount.csv");
                guestList = guestFile.getList(); //polymorphism method getList()
            }
        });
    }
    @FXML public void setNameGuest(String usernameGuest, String nameGuest) throws IOException {
        username.setText(usernameGuest);
        name.setText(nameGuest);
        this.nameGuest = nameGuest;
    }
    @FXML public void handleSuccessReceiveButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/success_guest.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        SuccessGuest l = loader.getController();
        l.setNameGuest(nameGuest);
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

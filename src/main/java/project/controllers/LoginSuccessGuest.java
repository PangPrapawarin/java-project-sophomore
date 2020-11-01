package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import project.manageData.ManageGuestFile;
import project.models.guest.GuestList;

import java.io.IOException;

public class LoginSuccessGuest {
    private String nameGuest;
    private String usernameGuest;
    private GuestList guestList;
    private LoginGuest guest;
    private ManageGuestFile guestFile;

    @FXML private Label username;
    @FXML private Label name;
    @FXML private Button successReceiveButton;
    @FXML private Button logoutButton;

    @FXML public void initialize() throws IOException{
        guestFile = new ManageGuestFile("data", "guestAccount.csv");
        guestList = guestFile.getGuestList();
    }
    @FXML public void setNameGuest(String usernameGuest, String nameGuest) throws IOException {
        username.setText(usernameGuest);
        name.setText(nameGuest);
    }
    @FXML public void handleSuccessReceiveButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/success_receive.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        SuccessReceive l = loader.getController();
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

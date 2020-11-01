package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.manageData.ManageGuestFile;
import project.models.guest.GuestList;

import java.io.IOException;

public class LoginGuest {
    private String username;
    private String password;
    private GuestList guestList;
    private ManageGuestFile guestData;
    private LoginSuccessGuest nextPage;

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginGuestButton;
    @FXML private Button forgetPasswordButton;
    @FXML private Button newGuestAccountButton;
    @FXML private Label alertLabel;

    @FXML public void initialize(){
        guestData = new ManageGuestFile("data", "guestAccount.csv");
        guestList = guestData.getGuestList();
    }
    @FXML public void handleLoginGuestButton(ActionEvent event) throws IOException {
        username = usernameField.getText();
        password = passwordField.getText();
        if (!(username.equals("") && password.equals(""))) {
            if (guestList.checkUsernameGuestWhenLogin(username)) {
                Button b = (Button) event.getSource();
                Stage stage = (Stage) b.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/login_success_guest.fxml"));

                stage.setScene(new Scene(loader.load(), 600, 600));
                LoginSuccessGuest l = loader.getController();
                l.setNameGuest(username,guestList.getNameGuest(username));
                stage.show();
            } else {
                alertLabel.setText("ไม่มีบัญชีผู้ใช้นี้");
            }
        } else {
            alertLabel.setText("กรุณากรอกข้อมูลให้ครบถ้วน");
        }
    }
    @FXML public void handlePreviousButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/home.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        Home l = loader.getController();
        stage.show();
    }
    @FXML public void handleForgetPasswordButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/forget_password.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        ForgetPassword l = loader.getController();
        stage.show();
    }
    @FXML public void handleNewGuestAccountButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/register_guest.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        RegisterGuest l = loader.getController();
        stage.show();
    }
}

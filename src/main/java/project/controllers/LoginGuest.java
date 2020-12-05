package project.controllers;

import javafx.application.Platform;
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
import project.manageData.ManageStaffFile;
import project.models.AdminList;
import project.models.GuestAccount;
import project.models.GuestList;

import java.io.IOException;

public class LoginGuest {
    private String username;
    private String password;
    private AdminList guestList;
    private ManageStaffFile guestData;
    private LoginSuccessGuest nextPage;

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginGuestButton;
    @FXML private Button forgetPasswordButton;
    @FXML private Button newGuestAccountButton;
    @FXML private Label alertLabel;

    @FXML
    public void initialize() {
        Platform.runLater((Runnable)new Runnable() {
            @Override
            public void run() {
                guestData = new ManageGuestFile("data", "guestAccount.csv");
                guestList = (GuestList) guestData.getList(); //casting
            }
        });
    }
    @FXML public void handleLoginGuestButton(ActionEvent event) throws IOException {
        username = usernameField.getText();
        password = passwordField.getText();
        if (!(username.equals("") || password.equals(""))) {
            if (guestList.checkUsername(username) && guestList.checkAccount(username,password)) { //polymorphism method checkAccount(,)
                Button b = (Button) event.getSource();
                Stage stage = (Stage) b.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/login_success_guest.fxml"));

                stage.setScene(new Scene(loader.load(), 600, 600));
                LoginSuccessGuest l = loader.getController();
                l.setNameGuest(username,guestList.getName(username));
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

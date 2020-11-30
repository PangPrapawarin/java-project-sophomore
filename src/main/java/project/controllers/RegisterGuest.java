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
import project.manageData.ManageNewGuestInfoFile;
import project.models.AdminAccount;
import project.models.GuestAccount;
import project.models.Condo;

import java.io.IOException;

public class RegisterGuest {
    private String name;
    private String username;
    private String password;
    private String confirmPassword;
    private GuestAccount guestAccount,guestList;
    private ManageGuestFile guestFile;
    private Condo condo,guestInfoList;
    private ManageNewGuestInfoFile guestInfoFile;

    @FXML private TextField nameField;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Button previousButton;
    @FXML private Button newAccountButton;
    @FXML private Label alertLabel;

    @FXML public void initialize(){
        guestInfoFile = new ManageNewGuestInfoFile("data", "guestInfoAccount.csv");
        guestInfoList = guestInfoFile.getGuestInfoList();
        guestFile = new ManageGuestFile("data","guestAccount.csv");
        guestList = guestFile.getGuestList();
    }
    @FXML public void handlePreviousButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/login_guest.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        LoginGuest l = loader.getController();
        stage.show();
    }
    @FXML public void handleNewAccountButton(ActionEvent event) throws IOException {
        name = nameField.getText();
        username = usernameField.getText();
        password = passwordField.getText();
        confirmPassword = confirmPasswordField.getText();
        if (!(name.equals("")||username.equals("")||password.equals("")||confirmPassword.equals(""))) {
            if (password.equals(confirmPassword)) {
                if (guestInfoList.checkHaveNameGuest(name)) {
                    if (!(guestList.checkUsername(username))) {
                        AdminAccount guestAccount = new GuestAccount(name, username, password, confirmPassword);
                        guestList.addAccount(guestAccount);
                        guestFile.setGuestList(guestList);
                        Button b = (Button) event.getSource();
                        Stage stage = (Stage) b.getScene().getWindow();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/login_guest.fxml"));

                        stage.setScene(new Scene(loader.load(), 600, 600));
                        LoginGuest l = loader.getController();
                        stage.show();
                    } else {
                        alertLabel.setText("มี username นี้แล้ว กรุณาเเปลี่ยน username ใหม่");
                    }
                } else {
                    alertLabel.setText("ไม่มีชื่อผู้เข้าพักนี้");
                }
            } else {
                alertLabel.setText("รหัสผ่านไม่ตรงกับยืนยันรหัสผ่าน");
            }
        } else {
            alertLabel.setText("กรุณากรอกข้อมูลให้ครบถ้วน");
        }
    }
}

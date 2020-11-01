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
import project.manageData.ManageAdminFile;
import project.models.admin.AdminList;

import java.io.IOException;

public class LoginAdmin {
    private String username;
    private String password;
    private AdminList adminList;
    private ManageAdminFile adminData;

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginAdminButton;
    @FXML private Button forgetPasswordButton;
    @FXML private Label alertLabel;

    @FXML public void initialize(){
        adminData = new ManageAdminFile("data","adminAccount.csv");
        adminList = adminData.getAdminsList();
    }
    @FXML public void handleLoginAdminButton(ActionEvent event) throws IOException {
        username = usernameField.getText();
        password = passwordField.getText();
        if (!(username.equals("")||password.equals(""))) {
            if (adminList.checkAdminAccount(username,password)){
                Button b = (Button) event.getSource();
                Stage stage = (Stage) b.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/login_success_admin.fxml"));

                stage.setScene(new Scene(loader.load(),600,600));
                LoginSuccessAdmin l = loader.getController();
                stage.show();
            }
            else {
                alertLabel.setText("กรุณาตรวจสอบชื่อบัญชีผู้ใช้และรหัสผ่านอีกครั้ง");
            }
        }
        else {
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
}

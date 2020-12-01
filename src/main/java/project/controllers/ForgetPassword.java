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
import project.manageData.ManageGuestFile;
import project.manageData.ManageStaffFile;
import project.models.*;

import java.io.IOException;

public class ForgetPassword {
    private String username;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
    private AdminList staffList,adminList,guestList; //polymorphism
    private ManageStaffFile staffFile;
    private ManageAdminFile adminFile;
    private ManageGuestFile guestFile;

    @FXML private TextField usernameField;
    @FXML private PasswordField oldPasswordField;
    @FXML private PasswordField newPasswordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Button previousButton;
    @FXML private Button newPasswordButton;
    @FXML private Label alertLabel;

    @FXML public void initialize(){
        adminFile = new ManageAdminFile("data","adminAccount.csv");
        adminList = adminFile.getList(); //polymorphism method getList()
        staffFile = new ManageStaffFile("data","staffAccount.csv");
        staffList = staffFile.getList();
        guestFile = new ManageGuestFile("data","guestAccount.csv");
        guestList = guestFile.getList(); //polymorphism method getList()
    }
    @FXML public void handlePreviousButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/home.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        Home l = loader.getController();
        stage.show();
    }
    @FXML public void handleNewPasswordButton(ActionEvent event) throws IOException {
        username = usernameField.getText();
        oldPassword = oldPasswordField.getText();
        newPassword = newPasswordField.getText();
        confirmPassword = confirmPasswordField.getText();
        if (!(username.equals("")&&oldPassword.equals("")&&newPassword.equals("")&&confirmPassword.equals(""))) {
            if (newPassword.equals(confirmPassword)) {
                if (staffList.checkAccount(username, oldPassword) || adminList.checkAccount(username, oldPassword) || guestList.checkAccount(username, oldPassword)) {
                    Button b = (Button) event.getSource();
                    Stage stage = (Stage) b.getScene().getWindow();
                    if (staffList.checkAccount(username, oldPassword)) {
                        staffList.setPassword(username, newPassword, confirmPassword);
                        staffFile.setStaffs((StaffList) staffList); //casting
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/login_staff.fxml"));

                        stage.setScene(new Scene(loader.load(), 600, 600));
                        LoginStaff l = loader.getController();
                        stage.show();
                    } else if (adminList.checkAccount(username, oldPassword)) {
                        adminList.setPassword(username, newPassword, confirmPassword);
                        adminFile.setAdminList(adminList);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/login_admin.fxml"));

                        stage.setScene(new Scene(loader.load(), 600, 600));
                        LoginAdmin l = loader.getController();
                        stage.show();
                    } else if (guestList.checkAccount(username, oldPassword)) {
                        guestList.setPassword(username, newPassword, confirmPassword);
                        guestFile.setGuestList((GuestList) guestList); //casting
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/login_guest.fxml"));

                        stage.setScene(new Scene(loader.load(), 600, 600));
                        LoginGuest l = loader.getController();
                        stage.show();
                    }
                } else {
                    alertLabel.setText("ไม่มีบัญชีผู้ใช้นี้");
                }
            } else {
                alertLabel.setText("รหัสผ่านใหม่ไม่ตรงกับรหัสผ่านยืนยัน");
            }
        } else {
            alertLabel.setText("กรุณากรอกข้อมูลให้ครบถ้วน");
        }
    }
}

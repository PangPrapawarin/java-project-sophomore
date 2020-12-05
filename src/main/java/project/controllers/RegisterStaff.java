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
import project.manageData.ManageStaffFile;
import project.models.AdminAccount;
import project.models.AdminList;
import project.models.StaffAccount;
import project.models.StaffList;

import java.io.IOException;

public class RegisterStaff {
    private String name;
    private String username;
    private String password;
    private String confirmPassword;
    private String time;
    private AdminList staffList;
    private ManageStaffFile staffData;

    @FXML private TextField staffNameField;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Button previousButton;
    @FXML private Button newAccountButton;
    @FXML private Label alertLabel;

    @FXML public void initialize(){
        staffData = new ManageStaffFile("data", "staffAccount.csv");
        staffList = (StaffList) staffData.getList(); //casting
    }
    @FXML public void handlePreviousButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/login_success_admin.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        LoginSuccessAdmin l = loader.getController();
        stage.show();
    }
    @FXML public void handleNewAccountButton(ActionEvent event) throws IOException {
        name = staffNameField.getText();
        username = usernameField.getText();
        password = passwordField.getText();
        confirmPassword = confirmPasswordField.getText();
        if (!(name.equals("")||username.equals("")||password.equals("")||confirmPassword.equals(""))){
            if (password.equals(confirmPassword)){
                if (!(staffList.checkUsername(username))) {
                    AdminAccount staffAccount = new StaffAccount(name,username,password,confirmPassword,"allow","-"); //polymorphism
                    staffList.addAccount(staffAccount); //polymorphism method addAccount()
                    staffData.setStaffs(staffList);
                    Button b = (Button) event.getSource();
                    Stage stage = (Stage) b.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/login_success_admin.fxml"));

                    stage.setScene(new Scene(loader.load(),600,600));
                    LoginSuccessAdmin l = loader.getController();
                    stage.show();
                } else {
                    alertLabel.setText("มีชื่อบัญชีผู้ใช้นี้แล้ว กรุณาเปลี่ยนชื่อบัญชีผู้ใช้ใหม่");
                }
            } else {
                alertLabel.setText("รหัสผ่านกับยืนยันรหัสผ่านไม่ตรงกัน");
            }
        } else {
            alertLabel.setText("กรุณากรอกข้อมูลให้ครบถ้วน");
        }
    }
}

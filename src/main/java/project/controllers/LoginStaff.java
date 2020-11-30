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
import project.models.StaffAccount;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoginStaff {
    private String username;
    private String password;
    private StaffAccount staffAccount,staffList;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private ManageStaffFile staffData;

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginStaffButton;
    @FXML private Button forgetPasswordButton;
    @FXML private Label alertLabel;

    public String getUsername() {
        return username;
    }
    @FXML public void initialize(){
        staffData = new ManageStaffFile("data", "staffAccount.csv");
        staffList = staffData.getStaffsList();
    }
    @FXML public void handleLoginStaffButton(ActionEvent event) throws IOException {
        username = usernameField.getText();
        password = passwordField.getText();
        if (!(username.equals("")||password.equals(""))) {
            if (staffList.checkAccount(username,password)) {
                if (staffList.checkUsernameStaffWhenLogin(username)) {
                    staffList.setTimeStaff(username,localDateTime.format(dateTimeFormatter));
                    staffData.setStaffs(staffList);
                    Button b = (Button) event.getSource();
                    Stage stage = (Stage) b.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/login_success_staff.fxml"));
                    stage.setScene(new Scene(loader.load(), 600, 600));
                    LoginSuccessStaff l = loader.getController();
                    l.setNameStaff(username,staffList.getName(username));
                    stage.show();
                } else {
                    alertLabel.setText("คุณถูกจำกัดสิทธิ์ในการเข้าใช้งาน");
                }
            } else {
                alertLabel.setText("ไม่มีบัญชีนี้อยู่ในระบบ");
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
}

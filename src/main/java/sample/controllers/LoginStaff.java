package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.manageData.ManageStaffFile;
import sample.models.CreateAccounts;
import sample.models.staff.StaffCreateAccount;
import sample.models.staff.StaffList;

import java.io.IOException;

public class LoginStaff {
    private String username;
    private String password;
    private StaffList staffList;
    private ManageStaffFile staffData;

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginStaffButton;
    @FXML private Label forgetPassword;

    @FXML public void initialize(){
        staffData = new ManageStaffFile("data", "staffAccount.csv");
        staffList = staffData.getStaffsList();
    }
    @FXML public void handleLoginStaffButton(ActionEvent event) throws IOException {
        username = usernameField.getText();
        password = passwordField.getText();
        CreateAccounts name = new StaffCreateAccount(staffList.getClass().getName(),username,password,"");
        if (!(username.equals("")&&password.equals(""))) {
            if (username.equals(name.getUsername())) {
                Button b = (Button) event.getSource();
                Stage stage = (Stage) b.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/login_success_staff.fxml"));

                stage.setScene(new Scene(loader.load(),600,600));
                LoginSuccessStaff l = loader.getController();
                stage.show();
            }
        }
    }
    @FXML public void handleForgetPasswordLabel(ActionEvent event) throws IOException {
        Label b = (Label) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/forget_password.fxml"));

        stage.setScene(new Scene(loader.load(),500,500));
        ForgetPassword l = loader.getController();
        stage.show();
    }
}

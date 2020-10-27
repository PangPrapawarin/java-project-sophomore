package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.manageData.ManageStaffFile;
import sample.models.CheckLogin;
import sample.models.CreateAccounts;
import sample.models.staff.StaffCreateAccount;
import sample.models.staff.StaffList;

import java.io.IOException;

public class RegisterStaff {
    private CreateAccounts staff;
    private StaffList staffsAccount;
    private CheckLogin check;
    private StaffList staffList;
    private ManageStaffFile staffData;

    @FXML private TextField staffNameField;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Button previousButton;
    @FXML private Button newAccountButton;

    @FXML public void initialize(){
        staffData = new ManageStaffFile("data", "staffAccount.csv");
        staffList = staffData.getStaffsList();
    }
    @FXML public void handlePreviousButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/login_success_admin.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        LoginSuccessAdmin l = loader.getController();
        stage.show();
    }
    @FXML public void handleNewAccountButton(ActionEvent event) throws IOException {
        String name = staffNameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        if (!(name.equals("")&&username.equals("")&&password.equals("")&&confirmPassword.equals(""))){
            if (check.checkLogin(password,confirmPassword)){
                StaffCreateAccount staffAccount = new StaffCreateAccount(name,username,password,confirmPassword);
                staffList.addStaff(staffAccount);
                staffData.setStaffs(staffList);
                Button b = (Button) event.getSource();
                Stage stage = (Stage) b.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/login_success_admin.fxml"));

                stage.setScene(new Scene(loader.load(),600,600));
                LoginSuccessAdmin l = loader.getController();
                stage.show();
            }
        }
    }
}

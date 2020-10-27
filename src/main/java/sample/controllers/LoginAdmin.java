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
import sample.manageData.ManageAdminFile;
import sample.models.CreateAccounts;
import sample.models.admin.AdminCreateAccount;
import sample.models.admin.AdminList;
import sample.models.staff.StaffCreateAccount;

import java.io.IOException;

public class LoginAdmin {
    private String username;
    private String password;
    private AdminList adminList;
    private ManageAdminFile adminData;

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginAdminButton;
    @FXML private Label forgetPassword;

    @FXML public void initialize(){
        adminData = new ManageAdminFile("data","adminAccount.csv");
        adminList = adminData.getAdminsList();
    }
    @FXML public void handleLoginAdminButton(ActionEvent event) throws IOException {
        username = usernameField.getText();
        password = passwordField.getText();
        CreateAccounts name = new AdminCreateAccount(adminList.getClass().getName(),adminList.getClass());
        if (!(username.equals("")&&password.equals(""))) {
            if (username.equals())
        }
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/login_success_admin.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        LoginSuccessAdmin l = loader.getController();
        stage.show();
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

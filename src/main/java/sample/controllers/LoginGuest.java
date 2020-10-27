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
import sample.manageData.ManageGuestFile;
import sample.models.guest.GuestList;

import java.io.IOException;

public class LoginGuest {
    private String username;
    private String password;
    private GuestList guestList;
    private ManageGuestFile guestData;

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginGuestButton;
    @FXML private Label forgetPassword;
    @FXML private Label newGuestAccount;

    @FXML public void initialize(){
        guestData = new ManageGuestFile("data", "guestAccount.csv");
        //guestList = guestData.getGuestsList();
    }
    @FXML public void handleLoginGuestButton(ActionEvent event) throws IOException {
        username = usernameField.getText();
        password = passwordField.getText();
        //CreateAccounts name = new GuestCreateAccount(guestList.getClass().getName(), username, password, "");
        if (!(username.equals("") && password.equals(""))) {
            //if (username.equals(name.getUsername())) {
                Button b = (Button) event.getSource();
                Stage stage = (Stage) b.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/login_success_guest.fxml"));

                stage.setScene(new Scene(loader.load(), 600, 600));
                LoginSuccessGuest l = loader.getController();
                stage.show();
            //}
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
    @FXML public void handleNewGuestAccountLabel(ActionEvent event) throws IOException {
        Label b = (Label) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/register_guest.fxml"));

        stage.setScene(new Scene(loader.load(),500,500));
        RegisterGuest l = loader.getController();
        stage.show();
    }
}

package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class LoginSuccessGuest {
    @FXML private ImageView photo;
    @FXML private Label username;
    @FXML private Label name;
    @FXML private Label changePassword;
    @FXML private Button successReceiveButton;
    @FXML private Button logoutButton;

    @FXML public void handleChangePasswordLabel(ActionEvent event) throws IOException {
        Label b = (Label) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/...fxml"));

        stage.setScene(new Scene(loader.load(),500,500));
        //... l = loader.getController();
        stage.show();
    }
    @FXML public void handleSuccessReceiveButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/success_receive.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        SuccessReceive l = loader.getController();
        stage.show();
    }
    @FXML public void handleLogoutButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/home.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        Home l = loader.getController();
        stage.show();
    }
}

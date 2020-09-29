package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginSuccessStaff {
    @FXML private TableView timeInfoStaffTable;
    @FXML private ImageView photo;
    @FXML private Label username;
    @FXML private Label name;
    @FXML private Label changePassword;
    @FXML private Button detailGuestButton;
    @FXML private Button manageButton;
    @FXML private Button logoutButton;

    @FXML public void handleChangePasswordLabel(ActionEvent event) throws IOException {
        Label b = (Label) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/...fxml"));

        stage.setScene(new Scene(loader.load(),500,500));
        //... l = loader.getController();
        stage.show();
    }
    @FXML public void handleManageButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/manage.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        Manage l = loader.getController();
        stage.show();
    }
    @FXML public void handleDetailGuestButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/detail_room.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        DetailRoom l = loader.getController();
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

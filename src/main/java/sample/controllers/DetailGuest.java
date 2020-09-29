package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class DetailGuest {
    @FXML private ImageView photo;
    @FXML private Label roomNumber;
    @FXML private Label floorNumber;
    @FXML private Label buildingNumber;
    @FXML private Label roomType;
    @FXML private Label date;
    @FXML private Label numberOfGuest;
    @FXML private Label guestName;
    @FXML private Button previousButton;
    @FXML private Button logoutButton;

    @FXML public void handlePreviousButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/detail_room.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        PopUpRecommend l = loader.getController();
        stage.show();
    }
    @FXML public void handleLogoutButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/home.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        PopUpRecommend l = loader.getController();
        stage.show();
    }
}

package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class NewGuest {
    @FXML private ImageView photo;
    @FXML private TextField roomNumberField;
    @FXML private TextField floorNumberField;
    @FXML private TextField buildingNumberField;
    @FXML private ChoiceBox roomType;
    @FXML private DatePicker datePicker;
    @FXML private TextField numberOfGuestField;
    @FXML private TextField guestNameField;
    @FXML private Button confirmButton;
    @FXML private Button previousButton;
    @FXML private Button logoutButton;

    @FXML public void handleConfirmButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/detail_room.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        DetailRoom l = loader.getController();
        stage.show();
    }
    @FXML public void handlePreviousButton(ActionEvent event) throws IOException {
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

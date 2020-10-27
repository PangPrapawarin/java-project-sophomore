package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class NewThings {
    private String form;
    private String nameSender;
    private String nameReceiver;
    private String roomNumber;
    private String staffName;

    @FXML private ImageView photo;
    @FXML private TextField formField;
    @FXML private TextField nameSenderField;
    @FXML private TextField nameReceiverField;
    @FXML private TextField roomNumberField;
    @FXML private TextField companyNameField;
    @FXML private TextField trackingNumberField;
    @FXML private DatePicker datePicker;
    @FXML private TextField staffNameField;
    @FXML private Button addPhotoButton;
    @FXML private Button confirmButton;
    @FXML private Button previousButton;
    @FXML private Button logoutButton;
    @FXML private CheckBox choiceBoxSmall;
    @FXML private CheckBox choiceBoxMedium;
    @FXML private CheckBox choiceBoxBig;

    @FXML
    public void handleAddPhotoButton(ActionEvent event) throws IOException {
        //
    }

    @FXML
    public void handleConfirmButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/manage.fxml"));

        stage.setScene(new Scene(loader.load(), 600, 600));
        Manage l = loader.getController();
        stage.show();
    }

    @FXML
    public void handlePreviousButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/new_manage.fxml"));

        stage.setScene(new Scene(loader.load(), 600, 600));
        NewManage l = loader.getController();
        stage.show();
    }

    @FXML
    public void handleLogoutButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/home.fxml"));

        stage.setScene(new Scene(loader.load(), 600, 600));
        Home l = loader.getController();
        stage.show();
    }

}

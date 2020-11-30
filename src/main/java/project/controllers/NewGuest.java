package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.manageData.ManageNewGuestInfoFile;
import project.models.Condo;

import java.io.IOException;

public class NewGuest {
    private String guestName;
    private String roomNumber;
    private String floorNumber;
    private String buildingNumber;
    private String typeRoom;
    private String people;
    private ManageNewGuestInfoFile guestInfoFile;
    private Condo condo,guestInfoList;

    @FXML private TextField roomNumberField;
    @FXML private TextField floorNumberField;
    @FXML private TextField buildingNumberField;
    @FXML private ChoiceBox<String> roomType;
    @FXML private TextField guestNameField;
    @FXML private TextField guestNumberField;
    @FXML private Button confirmButton;
    @FXML private Button previousButton;
    @FXML private Button logoutButton;
    @FXML private Label alertLabel;

    @FXML public void initialize(){
        guestInfoFile = new ManageNewGuestInfoFile("data", "guestInfoAccount.csv");
        guestInfoList = guestInfoFile.getGuestInfoList();
        roomTypeOption();
    }
    private void roomTypeOption() {
        String[] options = {
                "1 ห้องนอน 1 ห้องน้ำ",
                "2 ห้องนอน 1 ห้องน้ำ",
                "2 ห้องนอน 2 ห้องน้ำ",
        };
        for (int i = 0; i < options.length; i++) {
            roomType.getItems().add(options[i]);
        }
        roomType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(options[0])) {
                typeRoom = newValue;
            } else if (newValue.equals(options[1])) {
                typeRoom = newValue;
            } else if (newValue.equals(options[2])) {
                typeRoom = newValue;
            }
        });
    }
    @FXML public void handleConfirmButton(ActionEvent event) throws IOException {
        guestName = guestNameField.getText();
        roomNumber = roomNumberField.getText();
        floorNumber = floorNumberField.getText();
        buildingNumber = buildingNumberField.getText();
        people = guestNumberField.getText();
        if (!(guestName.equals("")||roomNumber.equals("")||floorNumber.equals("")||buildingNumber.equals("")||typeRoom.equals("")||people.equals(""))) {
            if (guestInfoList.checkRoomCondo(buildingNumber, floorNumber, roomNumber)  && roomNumber.length() == 4) {
                if (guestInfoList.checkBuildingNumber(Integer.parseInt(buildingNumber))) {
                    if (guestInfoList.checkFloorNumber(Integer.parseInt(floorNumber))) {
                        if (!(guestInfoList.checkHaveRoom(roomNumber))) {
                            if (guestInfoList.checkRoomTypeGuest(typeRoom, people)) {
                                Condo info = new Condo(roomNumber, floorNumber, buildingNumber, typeRoom, guestName, people);
                                guestInfoList.addGuestInfo(info);
                                guestInfoFile.setGuestInfoList(guestInfoList);
                                Button b = (Button) event.getSource();
                                Stage stage = (Stage) b.getScene().getWindow();
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/detail_room.fxml"));

                                stage.setScene(new Scene(loader.load(), 600, 600));
                                DetailRoom l = loader.getController();
                                stage.show();
                            } else {
                                alertLabel.setText("ห้องพักนี้มีจำนวนคนพักเกินกำหนด");
                            }
                        } else {
                            alertLabel.setText("ห้องพักนี้มีในระบบแล้ว");
                        }
                    } else {
                        alertLabel.setText("กรุณากรอกหมายเลขชั้นให้ถูกต้อง");
                    }
                } else {
                    alertLabel.setText("กรุณากรอกหมายเลขอาคารให้ถูกต้อง");
                }
            } else {
                alertLabel.setText("กรุณากรอกหมายเลขห้องพัก หมายเลขชั้นและอาคารให้ถูกต้อง");
            }
        } else {
            alertLabel.setText("กรุณากรอกข้อมูลให้ครบถ้วน");
        }
    }
    @FXML public void handlePreviousButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/detail_room.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        DetailRoom l = loader.getController();
        stage.show();
    }
    @FXML public void handleLogoutButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/home.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        Home l = loader.getController();
        stage.show();
    }
}

package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import project.manageData.ManageNewGuestInfoFile;
import project.manageData.ManageStaffFile;
import project.manageData.ManageThingsFile;
import project.models.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewSupply {
    private String form;
    private String nameSender;
    private String nameReceiver;
    private String roomNumber;
    private String staffName;
    private String companyName;
    private String trackingNumber;
    private String size;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private ThingList suppliesList;
    private ManageThingsFile suppliesFile;
    private ManageStaffFile staffFile;
    private AdminList staffList;
    private ManageNewGuestInfoFile guestInfoFile;
    private Condo condo,guestInfoList;

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
    @FXML private Label alertLabel;

    @FXML public void initialize(){
        suppliesFile = new ManageThingsFile("data", "thingsList.csv");
        suppliesList = suppliesFile.getThingsList();
        staffFile = new ManageStaffFile("data","staffAccount.csv");
        staffList = (StaffList) staffFile.getList(); //casting
        guestInfoFile = new ManageNewGuestInfoFile("data","guestInfoAccount.csv");
        guestInfoList = guestInfoFile.getGuestInfoList();
    }
    @FXML public void setChoiceBoxSmall(ActionEvent event) throws IOException {
        choiceBoxMedium.setSelected(false);
        choiceBoxBig.setSelected(false);
    }
    @FXML public void setChoiceBoxMedium(ActionEvent event) throws IOException {
        choiceBoxSmall.setSelected(false);
        choiceBoxBig.setSelected(false);
    }
    @FXML public void setChoiceBoxBig(ActionEvent event) throws IOException {
        choiceBoxSmall.setSelected(false);
        choiceBoxMedium.setSelected(false);
    }
    @FXML public void handleConfirmButton(ActionEvent event) throws IOException {
        form = formField.getText();
        nameSender = nameSenderField.getText();
        nameReceiver = nameReceiverField.getText();
        roomNumber = roomNumberField.getText();
        staffName = staffNameField.getText();
        companyName = companyNameField.getText();
        trackingNumber = trackingNumberField.getText();
        if (!(form.equals("") || nameSender.equals("") || nameReceiver.equals("") || roomNumber.equals("") || staffName.equals("") || companyName.equals("") || trackingNumber.equals(""))) {
            if (choiceBoxSmall.isSelected()) {
                size = choiceBoxSmall.getText();
            }
            if (choiceBoxMedium.isSelected()) {
                size = choiceBoxMedium.getText();
            }
            if (choiceBoxBig.isSelected()) {
                size = choiceBoxBig.getText();
            }
            if (choiceBoxSmall.isSelected() || choiceBoxMedium.isSelected() || choiceBoxBig.isSelected()) {
                if (guestInfoList.checkHaveRoom(roomNumber)) {
                    if (guestInfoList.checkHaveNameGuest(nameReceiver)) {
                        if (staffList.checkHaveNameStaff(staffName)) {
                            Thing supply = new Thing("supply", form, nameSender, nameReceiver, roomNumber, localDateTime.format(dateTimeFormatter), staffName, size, companyName, trackingNumber, "-");
                            suppliesList.addThing(supply);
                            suppliesFile.setThingsList(suppliesList);
                            Button b = (Button) event.getSource();
                            Stage stage = (Stage) b.getScene().getWindow();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/manage.fxml"));

                            stage.setScene(new Scene(loader.load(), 600, 600));
                            Manage l = loader.getController();
                            stage.show();
                        } else {
                            alertLabel.setText("ไม่มีชื่อเจ้าหน้าที่ส่วนกลางในระบบ");
                        }
                    } else {
                        alertLabel.setText("ไม่มีชื่อผู้เข้าพักนี้ในระบบ");
                    }
                } else {
                    alertLabel.setText("ไม่มีห้องพักนี้ในระบบ");
                }
            } else {
                alertLabel.setText("กรุณาตรวจสอบข้อมูลใหม่");
            }
        } else {
            alertLabel.setText("กรุณากรอกข้อมูลให้ครบถ้วน");
        }
    }

    @FXML public void handlePreviousButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/new_manage.fxml"));

        stage.setScene(new Scene(loader.load(), 600, 600));
        NewManage l = loader.getController();
        stage.show();
    }

    @FXML
    public void handleLogoutButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/home.fxml"));

        stage.setScene(new Scene(loader.load(), 600, 600));
        Home l = loader.getController();
        stage.show();
    }

}

package project.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import project.manageData.ManageThingsFile;
import project.models.Thing;
import project.models.ThingList;

import java.io.IOException;

public class SuccessGuest {
    private String nameGuest;
    private ThingList successThingsList,notSuccessThingsList;
    private ManageThingsFile successThingsFile,notSuccessThingsFile;

    @FXML
    private TableColumn<Thing, String> nameColumn,roomNumberColumn,typeColumn,dateColumn,staffControlColumn,nameColumnn,roomNumberColumnn,typeColumnn,dateColumnn,staffControlColumnn;
    @FXML private TableView<Thing> successReceiveTable,notSuccessReceiveTable;
    @FXML private Button previousButton;
    @FXML private Button logoutButton;

    @FXML
    public void initialize() {
        Platform.runLater((Runnable)new Runnable() {
            @Override
            public void run() {
                setNameGuest(nameGuest);
        notSuccessThingsFile = new ManageThingsFile("data", "thingsList.csv");
        notSuccessThingsList = notSuccessThingsFile.getThingsList();
        notSuccessThingsList.addThingGuest(nameGuest);
        successThingsFile = new ManageThingsFile("data", "successThingsList.csv");
        successThingsList = successThingsFile.getThingsList();
        successThingsList.addThingGuest(nameGuest);
        showSuccessThingsListOne();
        showSuccessThingsListTwo();
            }
        });
    }
    public void setNameGuest(String nameGuest){
        this.nameGuest = nameGuest;
    }
    private void showSuccessThingsListOne() {
        if (notSuccessThingsList.showGuestThings(nameGuest)!=null) {
            ObservableList<Thing> thingsObservableList = FXCollections.observableArrayList(notSuccessThingsList.showGuestThings(nameGuest));
            nameColumnn.setCellValueFactory(new PropertyValueFactory<Thing, String>("nameReceiver"));
            roomNumberColumnn.setCellValueFactory(new PropertyValueFactory<Thing, String>("roomNumber"));
            typeColumnn.setCellValueFactory(new PropertyValueFactory<Thing, String>("type"));
            dateColumnn.setCellValueFactory(new PropertyValueFactory<Thing, String>("date"));
            staffControlColumnn.setCellValueFactory(new PropertyValueFactory<Thing, String>("staffName"));
            notSuccessReceiveTable.setItems(thingsObservableList);
        }
    }
    private void showSuccessThingsListTwo() {
        if (successThingsList.showGuestThings(nameGuest)!=null) {
            ObservableList<Thing> thingsObservableList = FXCollections.observableArrayList(successThingsList.showGuestThings(nameGuest));
            nameColumn.setCellValueFactory(new PropertyValueFactory<Thing, String>("nameReceiver"));
            roomNumberColumn.setCellValueFactory(new PropertyValueFactory<Thing, String>("roomNumber"));
            typeColumn.setCellValueFactory(new PropertyValueFactory<Thing, String>("type"));
            dateColumn.setCellValueFactory(new PropertyValueFactory<Thing, String>("date"));
            staffControlColumn.setCellValueFactory(new PropertyValueFactory<Thing, String>("staffName"));
            successReceiveTable.setItems(thingsObservableList);
        }
    }
    @FXML public void handlePreviousButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/login_success_guest.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        LoginSuccessGuest l = loader.getController();
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

package project.controllers;

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

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Manage {
    private String sortBy;
    private ManageThingsFile thingsFile,successThingsFile;
    private Thing thing,thingsList,successThingsList;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @FXML private TableColumn<Thing, String> nameColumn,roomNumberColumn,typeColumn,dateColumn,otherColumn,staffControlColumn;
    @FXML private TableView<Thing> manageTable;
    @FXML private Button newManageButton;
    @FXML private Button receiveButton;
    @FXML private Button successReceiveButton;
    @FXML private Button previousButton;
    @FXML private Button logoutButton;

    @FXML public void initialize(){
        thingsFile = new ManageThingsFile("data", "thingsList.csv");
        thingsList = thingsFile.getThingsList();
        successThingsFile = new ManageThingsFile("data", "successThingsList.csv");
        successThingsList = successThingsFile.getThingsList();
        showThingsList();
    }
    private void showThingsList() {
        ObservableList<Thing> thingsObservableList = FXCollections.observableArrayList(thingsList.getThings());
        nameColumn.setCellValueFactory(new PropertyValueFactory<Thing, String>("nameReceiver"));
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<Thing, String>("roomNumber"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Thing, String>("type"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Thing, String>("date"));
        if (typeColumn.getSortType().equals("จดหมาย")){
            otherColumn.setCellValueFactory(new PropertyValueFactory<Thing, String>("-"));
        }
        else if (typeColumn.getSortType().equals("เอกสาร")){
            otherColumn.setCellValueFactory(new PropertyValueFactory<Thing, String>("important"));
        }
        else if (typeColumn.getSortType().equals("พัสดุ")){
            otherColumn.setCellValueFactory(new PropertyValueFactory<Thing, String>("trackingNumber"));
        }
        staffControlColumn.setCellValueFactory(new PropertyValueFactory<Thing, String>("staffName"));
        dateColumn.setSortType(TableColumn.SortType.DESCENDING);
        manageTable.setItems(thingsObservableList);
    }
    @FXML public void handleNewManageButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/new_manage.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        NewManage l = loader.getController();
        stage.show();
    }
    @FXML public void handleSuccessReceiveButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/success_receive.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        SuccessReceive l = loader.getController();
        stage.show();
    }
    @FXML public void handlePreviousButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/login_success_staff.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        LoginSuccessStaff l = loader.getController();
        stage.show();
    }
    @FXML public void handleReceiveButton(ActionEvent event) throws IOException {
        ObservableList<Thing> allThings;
        allThings = manageTable.getItems();
        Thing thingSelect = manageTable.getSelectionModel().getSelectedItem();
        thingSelect.setDate(localDateTime.format(dateTimeFormatter));
        successThingsList.addThing(thingSelect);
        successThingsFile.setThingsList(successThingsList);
        thingsList.removeThing(thingSelect);
        thingsFile.setThingsList(thingsList);
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/manage.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        Manage l = loader.getController();
        stage.show();
        manageTable.getSelectionModel().clearSelection();
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

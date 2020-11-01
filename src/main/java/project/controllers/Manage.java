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
import project.manageData.ManageSuccessThingsFile;
import project.manageData.ManageThingsFile;
import project.models.things.CreateThings;
import project.models.things.SuccessMailAndOtherList;
import project.models.things.ThingsList;

import java.io.IOException;

public class Manage {
    private String sortBy;
    private ThingsList thingsList;
    private ManageThingsFile thingsFile;
    private SuccessMailAndOtherList successThingsList;
    private ManageSuccessThingsFile successThingsFile;

    @FXML private TableColumn<CreateThings, String> nameColumn,roomNumberColumn,typeColumn,dateColumn,otherColumn,staffControlColumn;
    @FXML private TableView<CreateThings> manageTable;
    @FXML private Button newManageButton;
    @FXML private Button receiveButton;
    @FXML private Button successReceiveButton;
    @FXML private Button previousButton;
    @FXML private Button logoutButton;

    @FXML public void initialize(){
        thingsFile = new ManageThingsFile("data", "thingsList.csv");
        thingsList = thingsFile.getThingsList();
        successThingsFile = new ManageSuccessThingsFile("data", "successThingsList.csv");
        successThingsList = successThingsFile.getSuccessMailAndOtherList();
        showThingsList();
    }
    private void showThingsList() {
        ObservableList<CreateThings> thingsObservableList = FXCollections.observableArrayList(thingsList.getThings());
        nameColumn.setCellValueFactory(new PropertyValueFactory<CreateThings, String>("nameReceiver"));
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<CreateThings, String>("roomNumber"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<CreateThings, String>("type"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<CreateThings, String>("date"));
        if (typeColumn.getSortType().equals("จดหมาย")){
            otherColumn.setCellValueFactory(new PropertyValueFactory<CreateThings, String>("-"));
        }
        else if (typeColumn.getSortType().equals("เอกสาร")){
            otherColumn.setCellValueFactory(new PropertyValueFactory<CreateThings, String>("important"));
        }
        else if (typeColumn.getSortType().equals("พัสดุ")){
            otherColumn.setCellValueFactory(new PropertyValueFactory<CreateThings, String>("trackingNumber"));
        }
        staffControlColumn.setCellValueFactory(new PropertyValueFactory<CreateThings, String>("staffName"));
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
        ObservableList<CreateThings> allThings;
        allThings = manageTable.getItems();
        CreateThings thingSelect = manageTable.getSelectionModel().getSelectedItem();
        successThingsList.addMailAndOther(thingSelect);
        successThingsFile.setSuccessMailAndOtherList(successThingsList);
        thingsList.removeThings(thingSelect);
        thingsFile.setThingsList(thingsList);
        manageTable.refresh();
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

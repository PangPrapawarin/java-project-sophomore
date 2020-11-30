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

public class SuccessReceive {
    private Thing thing,successThingsList;
    private ManageThingsFile successThingsFile;

    @FXML private TableColumn<Thing, String> nameColumn,roomNumberColumn,typeColumn,dateColumn,staffControlColumn;
    @FXML private TableView<Thing> successReceiveTable;
    @FXML private Button previousButton;
    @FXML private Button logoutButton;

    @FXML public void initialize(){
        successThingsFile = new ManageThingsFile("data", "successThingsList.csv");
        successThingsList = successThingsFile.getThingsList();
        showSuccessThingsList();
    }
    private void showSuccessThingsList() {
        ObservableList<Thing> thingsObservableList = FXCollections.observableArrayList(successThingsList.getThings());
        nameColumn.setCellValueFactory(new PropertyValueFactory<Thing, String>("nameReceiver"));
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<Thing, String>("roomNumber"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Thing, String>("type"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Thing, String>("date"));
        staffControlColumn.setCellValueFactory(new PropertyValueFactory<Thing, String>("staffName"));
        successReceiveTable.setItems(thingsObservableList);
    }
    @FXML public void handlePreviousButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/manage.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        Manage l = loader.getController();
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

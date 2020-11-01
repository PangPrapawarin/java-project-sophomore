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
import project.models.things.CreateThings;
import project.models.things.SuccessMailAndOtherList;

import java.io.IOException;

public class SuccessReceive {
    private SuccessMailAndOtherList successMailAndOtherList;
    private CreateThings things;
    private ManageSuccessThingsFile successThingsFile;

    @FXML private TableColumn<CreateThings, String> nameColumn,roomNumberColumn,typeColumn,dateColumn,staffControlColumn;
    @FXML private TableView<CreateThings> successReceiveTable;
    @FXML private Button previousButton;
    @FXML private Button logoutButton;

    @FXML public void initialize(){
        successThingsFile = new ManageSuccessThingsFile("data", "successThingsList.csv");
        successMailAndOtherList = successThingsFile.getSuccessMailAndOtherList();
        showSuccessThingsList();
    }
    private void showSuccessThingsList() {
        ObservableList<CreateThings> thingsObservableList = FXCollections.observableArrayList(successMailAndOtherList.getSuccessMailAndOther());
        nameColumn.setCellValueFactory(new PropertyValueFactory<CreateThings, String>("nameReceiver"));
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<CreateThings, String>("roomNumber"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<CreateThings, String>("type"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<CreateThings, String>("date"));
        staffControlColumn.setCellValueFactory(new PropertyValueFactory<CreateThings, String>("staffName"));
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

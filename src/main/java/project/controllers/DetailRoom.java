package project.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import project.manageData.ManageNewGuestInfoFile;
import project.models.Condo;

import java.io.IOException;

public class DetailRoom {
    private String nameSearch;
    private Condo guestInfo,guestInfoList;
    private LoginStaff loginStaff;
    private ManageNewGuestInfoFile guestInfoFile;
    private ObservableList<Condo> guestInfoObservableList;

    @FXML private TableColumn<Condo, String> nameColumn,roomNumberColumn,floorColumn,buildingColumn,roomTypeColumn,amountColumn;
    @FXML private TextField guestNameSearchField;
    @FXML private TableView guestTable;
    @FXML private Button searchButton;
    @FXML private Button newGuestButton;
    @FXML private Button previousButton;
    @FXML private Button logoutButton;
    @FXML private Label alertLabel;

    @FXML public void initialize(){
        guestInfoFile = new ManageNewGuestInfoFile("data", "guestInfoAccount.csv");
        guestInfoList = guestInfoFile.getGuestInfoList();
        showGuestInfoList();
    }
    private void showGuestInfoList() {
        guestInfoObservableList = FXCollections.observableArrayList(guestInfoList.getGuestInfoList());
        nameColumn.setCellValueFactory(new PropertyValueFactory<Condo, String>("name"));
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<Condo, String>("roomNumber"));
        floorColumn.setCellValueFactory(new PropertyValueFactory<Condo, String>("floorNumber"));
        buildingColumn.setCellValueFactory(new PropertyValueFactory<Condo, String>("buildingNumber"));
        roomTypeColumn.setCellValueFactory(new PropertyValueFactory<Condo, String>("roomType"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<Condo, String>("people"));
        guestTable.setItems(guestInfoObservableList);
    }
    @FXML public void handleSearchButton(ActionEvent event) throws IOException {
        nameSearch = guestNameSearchField.getText();
        if (!(guestNameSearchField.getText().equals(""))) {
            if (guestInfoList.search(nameSearch)!=null) {
                guestInfoObservableList = FXCollections.observableArrayList(guestInfoList.search(nameSearch));
                guestTable.setItems(guestInfoObservableList);
                guestTable.refresh();
            }
            else {
                alertLabel.setText("ไม่มีชื่อผู้พักอาศัยนี้");
            }
        }
        else {
            showGuestInfoList();
        }
    }
    @FXML public void handleNewGuestButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/new_guest.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        NewGuest l = loader.getController();
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
    @FXML public void handleLogoutButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/home.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        Home l = loader.getController();
        stage.show();
    }
}

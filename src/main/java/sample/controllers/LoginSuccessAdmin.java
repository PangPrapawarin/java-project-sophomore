package sample.controllers;

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
import ku.cs.classroom.models.Student;
import ku.cs.classroom.services.StringConfiguration;
import sample.manageData.ManageStaffFile;
import sample.models.staff.StaffCreateAccount;
import sample.models.staff.StaffList;

import java.io.IOException;
import java.util.ArrayList;

public class LoginSuccessAdmin {
    private StaffList staffList;
    private StaffCreateAccount staffSelect;
    private ManageStaffFile staffFile;
    private ObservableList<StaffCreateAccount> staffObservableList;

    @FXML private TableView<StaffCreateAccount> staffTable;
    @FXML private Button newStaffAccountButton;
    @FXML private Button logoutButton;
    @FXML private Button withholdButton;

    @FXML public void initialize(){
        ManageStaffFile staffData = new ManageStaffFile("data", "staffAccount.csv");
        staffList = staffData.getStaffsList();
    }
    private void showStaffList() {
        staffObservableList = FXCollections.observableArrayList(staffList.getStaffs());
        staffTable.setItems(staffObservableList);
        ArrayList<StringConfiguration> configs = new ArrayList<>();
        configs.add(new StringConfiguration("title:Staff Name", "field:name"));
        configs.add(new StringConfiguration("title:Username", "field:username"));
        configs.add(new StringConfiguration("title:Password", "field:password"));

        for (StringConfiguration conf: configs) {
            TableColumn col = new TableColumn(conf.get("title"));
            col.prefWidthProperty().bind(staffTable.widthProperty().multiply(3));
            col.setResizable(false);
            col.setCellValueFactory(new PropertyValueFactory<>(conf.get));
        }
    }
    @FXML public void handleNewStaffAccountButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/register_staff.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        RegisterStaff l = loader.getController();
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

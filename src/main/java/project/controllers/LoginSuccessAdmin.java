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
import project.manageData.ManageStaffFile;
import project.models.AdminAccount;
import project.models.AdminList;
import project.models.StaffAccount;
import project.models.StaffList;

import java.io.IOException;

public class LoginSuccessAdmin {
    private StaffList staffList;
    private ManageStaffFile staffFile;

    @FXML private TableView<AdminAccount> staffTable;
    @FXML private TableColumn<AdminAccount, String> usernameColumn,nameColumn,accessTimeColumn,withholdColumn;
    @FXML private Button newStaffAccountButton;
    @FXML private Button logoutButton;
    @FXML private Button withholdButton;

    @FXML public void initialize(){
        staffFile = new ManageStaffFile("data", "staffAccount.csv");
        staffList = (StaffList) staffFile.getList(); //casting
        showStaffList();
    }
    private void showStaffList() {
        ObservableList<AdminAccount> staffObservableList = FXCollections.observableArrayList(staffList.getAccountList());
        usernameColumn.setCellValueFactory(new PropertyValueFactory<AdminAccount, String>("username"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<AdminAccount, String>("name"));
        accessTimeColumn.setCellValueFactory(new PropertyValueFactory<AdminAccount, String>("time"));
        withholdColumn.setCellValueFactory(new PropertyValueFactory<AdminAccount, String>("withhold"));
        staffTable.getSortOrder().addAll(accessTimeColumn);
        accessTimeColumn.setSortType(TableColumn.SortType.DESCENDING);
        staffTable.setItems(staffObservableList);
    }
    @FXML public void handleNewStaffAccountButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFile/register_staff.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        RegisterStaff l = loader.getController();
        stage.show();
    }
    @FXML public void handleWithholdAction(ActionEvent event) throws IOException {
        AdminAccount staff = staffTable.getSelectionModel().getSelectedItem();
        staffList.setWithholdStaff((StaffAccount) staff);
        staffFile.setStaffs(staffList);
        staffTable.refresh();
        staffTable.getSelectionModel().clearSelection();
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

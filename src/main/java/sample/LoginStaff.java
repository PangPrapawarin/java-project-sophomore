package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginStaff {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginStaffButton;
    @FXML private Label forgetPassword;

    @FXML public void handleLoginStaffButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/login_success_staff.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        PopUpRecommend l = loader.getController();
        stage.show();
    }
}

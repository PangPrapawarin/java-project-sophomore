package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUpNisit {
    @FXML
    private Button backToHomeButton;

    @FXML public void handleBackToHomeButton(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/Home.fxml"));

        stage.setScene(new Scene(loader.load(),600,600));
        LoginStaff l = loader.getController();
        stage.show();
    }
}

package sample.models.mailNdocumentNthing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class CreateMails {
    @FXML private ImageView photo;
    @FXML private Button addPhotoButton;
    @FXML private Button confirmButton;
    @FXML private TextField fromField;
    @FXML private TextField nameReceiverField;
    @FXML private TextField roomNumberField;
    @FXML private TextField staffNameField;
    @FXML private TextField nameSenderField;
    @FXML private DatePicker datePicker;
    @FXML private ChoiceBox documentType;

    public void setPhoto(ActionEvent event, String uploadPath) throws IOException {
//        ImageView photo = new ImageView();
//        photo.showUploadPhoto(uploadPath);
    }

}

package pl.mefjuuuu.encryptionapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class WelcomeScreenController {

    @FXML
    private Button btnEncrypt;

    @FXML
    private Button btnDecrypt;

    @FXML
    private void handleButtonClick(ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == btnEncrypt) {
            loadEncryptStage();
        } else if (mouseEvent.getSource() == btnDecrypt) {
            loadDecryptStage();
        }
    }


    private void loadEncryptStage() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pl/mefjuuuu/encryptionapp/encryption/encryption.fxml")));
            Stage stage = (Stage) btnEncrypt.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadDecryptStage() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pl/mefjuuuu/encryptionapp/decryption/decryption.fxml")));
            Stage stage = (Stage) btnDecrypt.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
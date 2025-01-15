package pl.mefjuuuu.encryptionapp.controller.encryption;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import pl.mefjuuuu.encryptionapp.dto.CipherRequest;
import pl.mefjuuuu.encryptionapp.encryption.PlayfairCipher;
import pl.mefjuuuu.encryptionapp.service.CipherServiceImpl;

import java.io.IOException;
import java.util.Objects;

@RequiredArgsConstructor
public abstract class AbstractEncryptionController {

    protected final CipherServiceImpl cipherService = new CipherServiceImpl();
    protected CipherRequest cipherRequest;

    @FXML
    protected TextField textField;

    @FXML
    protected TextField encryptedTextField;


    @FXML
    private Button btnBackToMainMenu;


    @FXML
    protected void handleBackToMainMenuClick() {
        loadMainStage();
    }

    @FXML
    protected void handleEncryptClick() {
        String inputText = textField.getText();
        if (inputText.isEmpty()) {
            showAlert("Error", "Input text cannot be empty");
            return;
        }
        encryptedTextField.setText(cipherService.encrypt(textField.getText(), cipherRequest));
    }

    private void loadMainStage() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pl/mefjuuuu/encryptionapp/home-page.fxml")));
            Stage stage = (Stage) btnBackToMainMenu.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

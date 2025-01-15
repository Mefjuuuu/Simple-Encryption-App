package pl.mefjuuuu.encryptionapp.controller.decryption;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import pl.mefjuuuu.encryptionapp.dto.CipherRequest;
import pl.mefjuuuu.encryptionapp.service.CipherServiceImpl;

import java.io.IOException;
import java.util.Objects;

@RequiredArgsConstructor
public abstract class AbstractDecryptionController {

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
    protected void handleDecryptClick() {
        String inputText = encryptedTextField.getText();
        if (inputText.isEmpty()) {
            showAlert("Error", "Encrypted text cannot be empty");
            return;
        }
        textField.setText(cipherService.decrypt(inputText, cipherRequest));
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

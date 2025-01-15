package pl.mefjuuuu.encryptionapp.controller.encryption.impl;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pl.mefjuuuu.encryptionapp.controller.encryption.AbstractEncryptionController;
import pl.mefjuuuu.encryptionapp.dto.CipherRequest;
import pl.mefjuuuu.encryptionapp.encryption.PlayfairCipher;

public class PlayfairEncryptionController extends AbstractEncryptionController {

    @FXML
    private TextField keyField;
    @FXML
    private TextField textField;
    @FXML
    private TextField encryptedTextField;

    public PlayfairEncryptionController() {
        this.cipherRequest = new CipherRequest("playfair");
    }

    @FXML
    protected void handleEncryptClick() {
        try {
            String key = keyField.getText();
            String plainText = textField.getText();

            if (key == null || key.isEmpty()) {
                showAlert("Error", "Key cannot be null or empty");
                return;
            }

            if (plainText == null || plainText.isEmpty()) {
                showAlert("Error", "Plain text cannot be null or empty");
                return;
            }

            PlayfairCipher playfairCipher = (PlayfairCipher) cipherService.getCipher(cipherRequest);
            playfairCipher.setKey(key);
            String encryptedMessage = playfairCipher.encrypt(plainText);
            encryptedTextField.setText(encryptedMessage);
        } catch (Exception ex) {
            showAlert("Error", "An error occurred during encryption: " + ex.getMessage());
        }
    }
}
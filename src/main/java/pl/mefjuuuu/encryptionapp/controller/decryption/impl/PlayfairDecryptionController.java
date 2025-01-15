package pl.mefjuuuu.encryptionapp.controller.decryption.impl;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pl.mefjuuuu.encryptionapp.controller.decryption.AbstractDecryptionController;
import pl.mefjuuuu.encryptionapp.dto.CipherRequest;
import pl.mefjuuuu.encryptionapp.encryption.PlayfairCipher;

public class PlayfairDecryptionController extends AbstractDecryptionController {

    @FXML
    private TextField keyField;
    @FXML
    private TextField encryptedTextField;
    @FXML
    private TextField textField;

    public PlayfairDecryptionController() {
        this.cipherRequest = new CipherRequest("playfair");
    }

    @FXML
    protected void handleDecryptClick() {
        try {
            String key = keyField.getText();
            String encryptedMessage = encryptedTextField.getText();

            if (key == null || key.isEmpty()) {
                showAlert("Error", "Key cannot be null or empty");
                return;
            }

            if (encryptedMessage == null || encryptedMessage.isEmpty()) {
                showAlert("Error", "Encrypted message cannot be null or empty");
                return;
            }

            PlayfairCipher playfairCipher = (PlayfairCipher) cipherService.getCipher(cipherRequest);
            playfairCipher.setKey(key);
            String decryptedMessage = playfairCipher.decrypt(encryptedMessage);
            textField.setText(decryptedMessage);
        } catch (Exception ex) {
            showAlert("Error", "An error occurred during decryption: " + ex.getMessage());
        }
    }
}
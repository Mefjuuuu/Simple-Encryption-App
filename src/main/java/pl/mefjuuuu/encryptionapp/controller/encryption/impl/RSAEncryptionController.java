package pl.mefjuuuu.encryptionapp.controller.encryption.impl;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pl.mefjuuuu.encryptionapp.controller.encryption.AbstractEncryptionController;
import pl.mefjuuuu.encryptionapp.dto.CipherRequest;
import pl.mefjuuuu.encryptionapp.encryption.RSACipher;

import java.math.BigInteger;

public class RSAEncryptionController extends AbstractEncryptionController {

    @FXML
    private TextField pField;
    @FXML
    private TextField qField;
    @FXML
    private TextField eField;
    @FXML
    private TextField textField;

    public RSAEncryptionController() {
        this.cipherRequest = new CipherRequest("rsa");
    }

    @FXML
    @Override
    protected void handleEncryptClick() {
        try {
            BigInteger p = new BigInteger(pField.getText());
            BigInteger q = new BigInteger(qField.getText());
            BigInteger e = new BigInteger(eField.getText());
            String message = textField.getText();

            if (message == null || message.isEmpty()) {
                showAlert("Error", "Message cannot be null or empty");
                return;
            }

            RSACipher rsaCipher = (RSACipher) cipherService.getCipher(cipherRequest);
            rsaCipher.setKeys(p, q, e);
            String encryptedMessage = rsaCipher.encrypt(message);
            encryptedTextField.setText(encryptedMessage);
        } catch (NumberFormatException ex) {
            showAlert("Error", "Invalid input for p, q, or e. Please enter valid numbers.");
        }
    }
}
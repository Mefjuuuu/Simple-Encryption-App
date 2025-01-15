package pl.mefjuuuu.encryptionapp.controller.decryption.impl;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pl.mefjuuuu.encryptionapp.controller.decryption.AbstractDecryptionController;
import pl.mefjuuuu.encryptionapp.dto.CipherRequest;
import pl.mefjuuuu.encryptionapp.encryption.RSACipher;

import java.math.BigInteger;

public class RSADecryptionController extends AbstractDecryptionController {

    @FXML
    private TextField pField;
    @FXML
    private TextField qField;
    @FXML
    private TextField eField;
    @FXML
    private TextField encryptedTextField;
    @FXML
    private TextField textField;

    public RSADecryptionController() {
        this.cipherRequest = new CipherRequest("rsa");
    }

    @FXML
    protected void handleDecryptClick() {
        try {
            String pText = pField.getText().trim();
            String qText = qField.getText().trim();
            String eText = eField.getText().trim();

            if (pText.isEmpty() || qText.isEmpty() || eText.isEmpty()) {
                showAlert("Error", "p, q, and e fields cannot be empty.");
                return;
            }

            if (!pText.matches("\\d+") || !qText.matches("\\d+") || !eText.matches("\\d+")) {
                showAlert("Error", "p, q, and e must be valid numbers.");
                return;
            }

            BigInteger p = new BigInteger(pText);
            BigInteger q = new BigInteger(qText);
            BigInteger e = new BigInteger(eText);
            String encryptedMessage = textField.getText().trim();

            if (encryptedMessage.isEmpty()) {
                showAlert("Error", "Encrypted message cannot be empty.");
                return;
            }

            RSACipher rsaCipher = (RSACipher) cipherService.getCipher(cipherRequest);
            rsaCipher.setKeys(p, q, e);
            String decryptedMessage = rsaCipher.decrypt(encryptedMessage);
            encryptedTextField.setText(decryptedMessage);
        } catch (NumberFormatException ex) {
            showAlert("Error", "Invalid input for p, q, or e. Please enter valid numbers.");
        } catch (Exception ex) {
            showAlert("Error", "An error occurred during decryption: " + ex.getMessage());
        }
    }

}
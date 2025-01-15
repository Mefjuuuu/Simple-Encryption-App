package pl.mefjuuuu.encryptionapp.controller.encryption.impl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pl.mefjuuuu.encryptionapp.controller.encryption.AbstractEncryptionController;
import pl.mefjuuuu.encryptionapp.dto.CipherRequest;

import java.io.IOException;
import java.util.Objects;

public class VigenereEncryptionController extends AbstractEncryptionController {

    public VigenereEncryptionController() {
        this.cipherRequest = new CipherRequest("vigenere");
    }
}

package pl.mefjuuuu.encryptionapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CipherEncryptionSelectionController {

    @FXML
    private Button btnBackToMainMenu;

    @FXML
    protected void handleCaesarEncryptButtonClick() {
        loadCaesar();
    }

    @FXML
    protected void handlePlayfairEncryptButtonClick() {
        loadPlayfair();
    }

    @FXML
    protected void handlePolybiusEncryptButtonClick() {
        loadPolybius();
    }

    @FXML
    protected void handleRSAEncryptButtonClick() {
        loadRSA();
    }

    @FXML
    protected void handleVigenereEncryptButtonClick() {
        loadVigenere();
    }

    @FXML
    protected void handleBackToMainMenuClick() {
        loadMainStage();
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

    private void loadVigenere() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pl/mefjuuuu/encryptionapp/encryption/vigenere_encryption.fxml")));
            Stage stage = (Stage) btnBackToMainMenu.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadRSA() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pl/mefjuuuu/encryptionapp/encryption/rsa_encryption.fxml")));
            Stage stage = (Stage) btnBackToMainMenu.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPolybius() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pl/mefjuuuu/encryptionapp/encryption/polybius_encryption.fxml")));
            Stage stage = (Stage) btnBackToMainMenu.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPlayfair() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pl/mefjuuuu/encryptionapp/encryption/playfair_encryption.fxml")));
            Stage stage = (Stage) btnBackToMainMenu.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCaesar() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pl/mefjuuuu/encryptionapp/encryption/caesar_encryption.fxml")));
            Stage stage = (Stage) btnBackToMainMenu.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

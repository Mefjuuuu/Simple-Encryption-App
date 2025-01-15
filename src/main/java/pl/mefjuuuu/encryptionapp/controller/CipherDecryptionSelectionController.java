package pl.mefjuuuu.encryptionapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CipherDecryptionSelectionController {

    @FXML
    private Button btnBackToMainMenu;

    @FXML
    protected void handleCaesarDecryptButtonClick() {
        loadCaesar();
    }

    @FXML
    protected void handlePlayfairDecryptButtonClick() {
        loadPlayfair();
    }

    @FXML
    protected void handlePolybiusDecryptButtonClick() {
        loadPolybius();
    }

    @FXML
    protected void handleRSADecryptButtonClick() {
        loadRSA();
    }

    @FXML
    protected void handleVigenereDecryptButtonClick() {
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
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pl/mefjuuuu/encryptionapp/decryption/vigenere_decryption.fxml")));
            Stage stage = (Stage) btnBackToMainMenu.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadRSA() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pl/mefjuuuu/encryptionapp/decryption/rsa_decryption.fxml")));
            Stage stage = (Stage) btnBackToMainMenu.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPolybius() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pl/mefjuuuu/encryptionapp/decryption/polybius_decryption.fxml")));
            Stage stage = (Stage) btnBackToMainMenu.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPlayfair() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pl/mefjuuuu/encryptionapp/decryption/playfair_decryption.fxml")));
            Stage stage = (Stage) btnBackToMainMenu.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCaesar() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pl/mefjuuuu/encryptionapp/decryption/caesar_decryption.fxml")));
            Stage stage = (Stage) btnBackToMainMenu.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
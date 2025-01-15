package pl.mefjuuuu.encryptionapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home-page.fxml")));
        stage.setTitle("Encryption App");
        stage.setScene(new Scene(root, 640, 480));

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
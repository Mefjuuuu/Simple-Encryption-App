module pl.mefjuuuu.encryptionapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires static lombok;

    opens pl.mefjuuuu.encryptionapp to javafx.fxml;
    exports pl.mefjuuuu.encryptionapp;
    exports pl.mefjuuuu.encryptionapp.controller;
    opens pl.mefjuuuu.encryptionapp.controller to javafx.fxml;
    opens pl.mefjuuuu.encryptionapp.controller.decryption to javafx.fxml;
    opens pl.mefjuuuu.encryptionapp.controller.encryption to javafx.fxml;
    opens pl.mefjuuuu.encryptionapp.controller.decryption.impl to javafx.fxml;
    opens pl.mefjuuuu.encryptionapp.controller.encryption.impl to javafx.fxml;
}
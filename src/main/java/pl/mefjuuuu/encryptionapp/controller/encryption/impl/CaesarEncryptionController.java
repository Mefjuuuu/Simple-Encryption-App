package pl.mefjuuuu.encryptionapp.controller.encryption.impl;

import pl.mefjuuuu.encryptionapp.controller.encryption.AbstractEncryptionController;
import pl.mefjuuuu.encryptionapp.dto.CipherRequest;

public class CaesarEncryptionController extends AbstractEncryptionController {

    public CaesarEncryptionController() {
        cipherRequest = new CipherRequest("caesar");
    }
}

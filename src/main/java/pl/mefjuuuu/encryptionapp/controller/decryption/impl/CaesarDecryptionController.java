package pl.mefjuuuu.encryptionapp.controller.decryption.impl;

import pl.mefjuuuu.encryptionapp.controller.decryption.AbstractDecryptionController;
import pl.mefjuuuu.encryptionapp.dto.CipherRequest;

public class CaesarDecryptionController extends AbstractDecryptionController {

    public CaesarDecryptionController() {
        this.cipherRequest = new CipherRequest("caesar");
    }
}

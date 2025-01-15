package pl.mefjuuuu.encryptionapp.controller.decryption.impl;

import pl.mefjuuuu.encryptionapp.controller.decryption.AbstractDecryptionController;
import pl.mefjuuuu.encryptionapp.dto.CipherRequest;

public class VigenereDecryptionController extends AbstractDecryptionController {

    public VigenereDecryptionController() {
        this.cipherRequest = new CipherRequest("vigenere");
    }
}

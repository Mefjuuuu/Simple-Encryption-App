package pl.mefjuuuu.encryptionapp.controller.decryption.impl;

import pl.mefjuuuu.encryptionapp.controller.decryption.AbstractDecryptionController;
import pl.mefjuuuu.encryptionapp.dto.CipherRequest;

public class PolybiusDecryptionController extends AbstractDecryptionController {

    public PolybiusDecryptionController() {
        this.cipherRequest = new CipherRequest("polybius");
    }
}
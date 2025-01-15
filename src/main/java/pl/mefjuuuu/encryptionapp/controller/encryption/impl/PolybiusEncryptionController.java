package pl.mefjuuuu.encryptionapp.controller.encryption.impl;

import pl.mefjuuuu.encryptionapp.controller.encryption.AbstractEncryptionController;
import pl.mefjuuuu.encryptionapp.dto.CipherRequest;

public class PolybiusEncryptionController extends AbstractEncryptionController {

    public PolybiusEncryptionController() {
        this.cipherRequest = new CipherRequest("polybius");
    }
}

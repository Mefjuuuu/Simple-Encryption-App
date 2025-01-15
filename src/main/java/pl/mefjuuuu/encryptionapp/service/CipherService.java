package pl.mefjuuuu.encryptionapp.service;

import pl.mefjuuuu.encryptionapp.dto.CipherRequest;

public interface CipherService {

    String encrypt(String input, CipherRequest request);

    String decrypt(String input, CipherRequest request);
}

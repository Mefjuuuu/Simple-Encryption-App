package pl.mefjuuuu.encryptionapp.service;

import pl.mefjuuuu.encryptionapp.dto.CipherRequest;
import pl.mefjuuuu.encryptionapp.encryption.*;

import java.util.HashMap;
import java.util.Map;

public class CipherServiceImpl implements CipherService {

    private final Map<String, Cipher> cipherRegistry = new HashMap<>();

    public CipherServiceImpl() {
        cipherRegistry.put("caesar", new CaesarCipher());
        cipherRegistry.put("vigenere", new VigenereCipher());
        cipherRegistry.put("playfair", new PlayfairCipher());
        cipherRegistry.put("polybius", new PolybiusCipher());
        cipherRegistry.put("rsa", new RSACipher());
    }

    @Override
    public String encrypt(String input, CipherRequest request) {
        Cipher cipher = cipherRegistry.get(request.getCipherType());
        if (cipher == null) {
            throw new IllegalArgumentException("Invalid cipher type: " + request.getCipherType());
        }
        return cipher.encrypt(input);
    }

    @Override
    public String decrypt(String input, CipherRequest request) {
        Cipher cipher = cipherRegistry.get(request.getCipherType());
        if (cipher == null) {
            throw new IllegalArgumentException("Invalid cipher type: " + request.getCipherType());
        }
        return cipher.decrypt(input);
    }

    public Cipher getCipher(CipherRequest cipherRequest) {
        return switch (cipherRequest.getCipherType()) {
            case "playfair" -> new PlayfairCipher();
            case "rsa" -> new RSACipher();
            case "vigenere" -> new VigenereCipher();
            case "caesar" -> new CaesarCipher();
            case "polybius" -> new PolybiusCipher();
            default -> throw new IllegalArgumentException("Unknown cipher type: " + cipherRequest.getCipherType());
        };
    }
}

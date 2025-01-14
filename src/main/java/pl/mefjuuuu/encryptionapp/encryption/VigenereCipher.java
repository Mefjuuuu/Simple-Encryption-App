package pl.mefjuuuu.encryptionapp.encryption;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VigenereCipher implements Cipher {

    private final String key;


    @Override
    public String encrypt(String input) {
        key.toLowerCase();
        input = preprocessInput(input);
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            char keyChar = key.charAt(i % key.length());
            char encryptedChar = (char) ((inputChar + keyChar - 2 * 'a') % 26 + 'a');
            encrypted.append(encryptedChar);
        }

        return encrypted.toString();
    }

    @Override
    public String decrypt(String input) {
        key.toLowerCase();
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            char keyChar = key.charAt(i % key.length());
            char decryptedChar = (char) ((inputChar - keyChar + 26) % 26 + 'a');
            decrypted.append(decryptedChar);
        }

        return decrypted.toString();
    }

    private String preprocessInput(String input) {
        return input.toLowerCase().replaceAll("[^a-z]", "");
    }
}
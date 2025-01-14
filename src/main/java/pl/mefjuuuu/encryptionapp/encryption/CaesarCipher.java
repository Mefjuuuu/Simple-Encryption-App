package pl.mefjuuuu.encryptionapp.encryption;

import lombok.RequiredArgsConstructor;
import pl.mefjuuuu.encryptionapp.config.AppConfig;

@RequiredArgsConstructor
public class CaesarCipher implements Cipher {

    private final int shift = AppConfig.CIPHER_SHIFT;

    @Override
    public String encrypt(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') return "";

            char shiftedChar = (char) (input.charAt(i) + shift);

            if (shiftedChar > 'z') {
                input = input.substring(0, i) + (char) (input.charAt(i) - (26 - shift)) + input.substring(i + 1);
            } else {
                input = input.substring(0, i) + shiftedChar + input.substring(i + 1);
            }
        }
        return input;
    }

    @Override
    public String decrypt(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') return "";

            char shiftedChar = (char) (input.charAt(i) - shift);

            if (shiftedChar < 'a') {
                input = input.substring(0, i) + (input.charAt(i) + (26 - shift)) + input.substring(i + 1);
            } else {
                input = input.substring(0, i) + shiftedChar + input.substring(i + 1);
            }
        }

        return input;
    }
}

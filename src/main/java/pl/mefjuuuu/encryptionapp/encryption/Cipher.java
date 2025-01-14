package pl.mefjuuuu.encryptionapp.encryption;

public interface Cipher {

    String encrypt(String input);

    String decrypt(String input);
}

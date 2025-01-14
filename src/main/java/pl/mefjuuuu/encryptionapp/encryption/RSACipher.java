package pl.mefjuuuu.encryptionapp.encryption;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Base64;

public class RSACipher implements Cipher {

    private PublicKey publicKey;
    private PrivateKey privateKey;

    public RSACipher() {
        generateKeys();
    }

    private void generateKeys() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048, new SecureRandom());
            KeyPair pair = keyGen.generateKeyPair();
            this.publicKey = pair.getPublic();
            this.privateKey = pair.getPrivate();
        } catch (Exception e) {
            throw new RuntimeException("Error generating RSA keys", e);
        }
    }

    @Override
    public String encrypt(String input) {
        try {
            byte[] inputBytes = input.getBytes();
            BigInteger inputBigInt = new BigInteger(1, inputBytes);
            BigInteger encryptedBigInt = inputBigInt.modPow(getPublicExponent(), getModulus());
            byte[] encryptedBytes = encryptedBigInt.toByteArray();
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting data", e);
        }
    }

    @Override
    public String decrypt(String input) {
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(input);
            BigInteger encryptedBigInt = new BigInteger(1, encryptedBytes);
            BigInteger decryptedBigInt = encryptedBigInt.modPow(getPrivateExponent(), getModulus());
            byte[] decryptedBytes = decryptedBigInt.toByteArray();
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error decrypting data", e);
        }
    }

    private BigInteger getModulus() {
        return ((java.security.interfaces.RSAPublicKey) publicKey).getModulus();
    }

    private BigInteger getPublicExponent() {
        return ((java.security.interfaces.RSAPublicKey) publicKey).getPublicExponent();
    }

    private BigInteger getPrivateExponent() {
        return ((java.security.interfaces.RSAPrivateKey) privateKey).getPrivateExponent();
    }
}
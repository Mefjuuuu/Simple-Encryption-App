package pl.mefjuuuu.encryptionapp.encryption;

import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class RSACipher implements Cipher {

    private BigInteger p;
    private BigInteger q;
    private BigInteger e;
    private BigInteger n;
    private BigInteger phi;
    private BigInteger d;

    public void setKeys(BigInteger p, BigInteger q, BigInteger e) {
        this.p = p;
        this.q = q;
        this.e = e;
        this.n = p.multiply(q);
        this.phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        this.d = modInverse(e, phi);

        if (d.equals(BigInteger.valueOf(-1))) {
            throw new IllegalStateException("The modular inverse cannot be found. Make sure e and phi are relatively prime.");
        }
    }

    @Override
    public String encrypt(String input) {
        if (d == null) {
            throw new IllegalStateException("The keys were not set correctly.");
        }

        List<BigInteger> encrypted = encryptText(input, e, n);
        return encrypted.stream().map(Object::toString).reduce((a, b) -> a + " " + b).orElse("");
    }

    @Override
    public String decrypt(String input) {
        if (d == null) {
            throw new IllegalStateException("The keys were not set correctly.");
        }

        List<BigInteger> encryptedNumbers = parseEncryptedInput(input);
        return decryptText(encryptedNumbers, d, n);
    }

    private BigInteger modInverse(BigInteger a, BigInteger m) {
        return a.modInverse(m);
    }

    private List<BigInteger> encryptText(String text, BigInteger e, BigInteger n) {
        List<BigInteger> encrypted = new ArrayList<>();
        for (char c : text.toCharArray()) {
            int ascii = c;
            encrypted.add(BigInteger.valueOf(ascii).modPow(e, n));
        }
        return encrypted;
    }

    private String decryptText(List<BigInteger> encrypted, BigInteger d, BigInteger n) {
        StringBuilder decrypted = new StringBuilder();
        for (BigInteger num : encrypted) {
            int ascii = num.modPow(d, n).intValue();
            decrypted.append((char) ascii);
        }
        return decrypted.toString();
    }

    private List<BigInteger> parseEncryptedInput(String input) {
        input = input.replaceAll("[\\[\\],]", "");
        String[] parts = input.split(", ");
        List<BigInteger> encryptedNumbers = new ArrayList<>();
        for (String part : parts) {
            encryptedNumbers.add(new BigInteger(part));
        }
        return encryptedNumbers;
    }
}

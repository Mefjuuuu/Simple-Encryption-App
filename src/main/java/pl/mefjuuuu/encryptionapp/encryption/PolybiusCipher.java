package pl.mefjuuuu.encryptionapp.encryption;

import java.util.HashMap;
import java.util.Map;

public class PolybiusCipher implements Cipher {

    private final char[][] matrix = {
            {'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'k'},
            {'l', 'm', 'n', 'o', 'p'},
            {'q', 'r', 's', 't', 'u'},
            {'v', 'w', 'x', 'y', 'z'}
    };

    private final Map<Character, String> charToCoordinates = new HashMap<>();
    private final Map<String, Character> coordinatesToChar = new HashMap<>();

    public PolybiusCipher() {
        initializeMaps();
    }

    private void initializeMaps() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                char c = matrix[row][col];
                String coordinates = "" + (row + 1) + (col + 1);
                charToCoordinates.put(c, coordinates);
                coordinatesToChar.put(coordinates, c);
            }
        }
    }

    @Override
    public String encrypt(String input) {
        input = preprocessInput(input);
        StringBuilder encrypted = new StringBuilder();

        for (char c : input.toCharArray()) {
            encrypted.append(charToCoordinates.get(c));
        }

        return encrypted.toString();
    }

    @Override
    public String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < input.length(); i += 2) {
            String coordinates = input.substring(i, i + 2);
            decrypted.append(coordinatesToChar.get(coordinates));
        }

        return decrypted.toString();
    }

    private String preprocessInput(String input) {
        return input.toLowerCase().replaceAll("[^a-z]", "").replace('j', 'i');
    }
}
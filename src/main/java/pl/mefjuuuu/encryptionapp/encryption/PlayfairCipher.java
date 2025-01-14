package pl.mefjuuuu.encryptionapp.encryption;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class PlayfairCipher implements Cipher {

    private char[][] matrix;
    private Map<Character, int[]> charPositions;

    public PlayfairCipher(String key) {
        generateMatrix(key);
    }

    private void generateMatrix(String key) {
        matrix = new char[5][5];
        charPositions = new HashMap<>();
        boolean[] used = new boolean[26];
        used['j' - 'a'] = true;

        int row = 0, col = 0;
        for (char c : key.toCharArray()) {
            if (c == 'j') c = 'i';

            if (!used[c - 'a']) {
                matrix[row][col] = c;
                charPositions.put(c, new int[]{row, col});
                used[c - 'a'] = true;
                if (++col == 5) {
                    col = 0;
                    row++;
                }
            }
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (!used[c - 'a']) {
                matrix[row][col] = c;
                charPositions.put(c, new int[]{row, col});
                if (++col == 5) {
                    col = 0;
                    row++;
                }
            }
        }
    }

    @Override
    public String encrypt(String input) {
        input = preprocessInput(input);
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < input.length(); i += 2) {
            char a = input.charAt(i);
            char b = input.charAt(i + 1);
            int[] posA = charPositions.get(a);
            int[] posB = charPositions.get(b);

            if (posA[0] == posB[0]) {
                encrypted.append(matrix[posA[0]][(posA[1] + 1) % 5]);
                encrypted.append(matrix[posB[0]][(posB[1] + 1) % 5]);
            } else if (posA[1] == posB[1]) {
                encrypted.append(matrix[(posA[0] + 1) % 5][posA[1]]);
                encrypted.append(matrix[(posB[0] + 1) % 5][posB[1]]);
            } else {
                encrypted.append(matrix[posA[0]][posB[1]]);
                encrypted.append(matrix[posB[0]][posA[1]]);
            }
        }

        return encrypted.toString();
    }

    @Override
    public String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < input.length(); i += 2) {
            char a = input.charAt(i);
            char b = input.charAt(i + 1);
            int[] posA = charPositions.get(a);
            int[] posB = charPositions.get(b);

            if (posA[0] == posB[0]) {
                decrypted.append(matrix[posA[0]][(posA[1] + 4) % 5]);
                decrypted.append(matrix[posB[0]][(posB[1] + 4) % 5]);
            } else if (posA[1] == posB[1]) {
                decrypted.append(matrix[(posA[0] + 4) % 5][posA[1]]);
                decrypted.append(matrix[(posB[0] + 4) % 5][posB[1]]);
            } else {
                decrypted.append(matrix[posA[0]][posB[1]]);
                decrypted.append(matrix[posB[0]][posA[1]]);
            }
        }

        return decrypted.toString();
    }

    private String preprocessInput(String input) {
        input = input.toLowerCase().replaceAll("[^a-z]", "").replace('j', 'i');
        StringBuilder processed = new StringBuilder(input);

        for (int i = 0; i < processed.length() - 1; i += 2) {
            if (processed.charAt(i) == processed.charAt(i + 1)) {
                processed.insert(i + 1, 'x');
            }
        }

        if (processed.length() % 2 != 0) {
            processed.append('x');
        }

        return processed.toString();
    }
}
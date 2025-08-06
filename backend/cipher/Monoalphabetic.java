package backend.cipher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Monoalphabetic implements Cipher {
    Map<Character, Character> characterMap = new HashMap<>();

    // Default Constructor
    public Monoalphabetic() {
        List<Character> shuffled = new ArrayList<>();

        for (char c = 'a'; c <= 'z'; c++) {
           shuffled.add(c);
        }

        Collections.shuffle(shuffled);

        char original = 'a';
        for (char value : shuffled) {
            characterMap.put(original++, value);
        }
    }

    @Override
    public String encrypt(String decryptedText) {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < decryptedText.length(); ++i) {
            char currentChar = decryptedText.charAt(i);
            Character encryptedChar = characterMap.get(currentChar);

            if (encryptedChar != null) {
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(currentChar);
            }
        }

        return encrypted.toString();
    }
    
    @Override
    public String decrypt(String encryptedText) {
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < encryptedText.length(); ++i) {
            char currentChar = encryptedText.charAt(i);
            boolean charFound = false;

            // check for the current encrypted character's decryption key
            for (Map.Entry<Character, Character> entry : characterMap.entrySet()) {
                if (entry.getValue() == currentChar) {
                    decrypted.append(entry.getKey());
                    charFound = true;
                    break;
                }
            }

            if (!charFound) {
                decrypted.append(currentChar);
            }
        }

        return decrypted.toString();
    }
}

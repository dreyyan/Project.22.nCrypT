package backend.cipher;

import java.util.HashMap;
import java.util.Map;

public class AtbashCipher implements Cipher {
    Map<Character, Character> characterMap = new HashMap<>();

    // Default Constructor
    public AtbashCipher() {
        for (char original = 'a'; original <= 'z'; ++original) {
            characterMap.put(original, (char)('z' - (original - 'a')));
        }
        for (char original = 'A'; original <= 'Z'; ++original) {
            characterMap.put(original, (char)('Z' - (original - 'A')));
        }
    }

    public String encrypt(String decryptedText) {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < decryptedText.length(); ++i) {
            encrypted.append(characterMap.get(decryptedText.charAt(i)));
        }

        return encrypted.toString();
    }

    public String decrypt(String encryptedText) {
        return encrypt(encryptedText);
    }
}

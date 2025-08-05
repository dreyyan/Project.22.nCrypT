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
            
        }

        return encrypted.toString();
    }
    
    @Override
    public String decrypt(String encryptedText) {
        StringBuilder decrypted = new StringBuilder();

        return decrypted.toString();
    }
}

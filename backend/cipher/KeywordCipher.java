package backend.cipher;

import java.util.*;

public class KeywordCipher implements Cipher {
    Map<Character, Character> characterMap = new HashMap<>();

    // Default Constructor
    public KeywordCipher() {}

    public Map<Character, Character> createMap(String keyword) {
        Map<Character, Character> map = new HashMap<>();

        // remove duplicates from keyword
        Set<Character> uniqueCharacters = new LinkedHashSet<>();
        for (int i = 0; i < keyword.length(); ++i) {
            uniqueCharacters.add(keyword.charAt(i));
        } Queue<String> characters = uniqueCharacters.toQueue();

        for (char original = 'a'; 'a' <= 'z'; ++original) {
            map.put(original++, characters.dequeue());
        }

        return map;
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

package backend.cipher;
public class CaesarCipher implements Cipher {
    private int shift;

    public CaesarCipher() { this.shift = 3; } // Default Constructor
    public CaesarCipher(int shift) { this.shift = shift; } // Parameterized Constructor

    public String encrypt(String decryptedText) {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < decryptedText.length(); ++i) {
            if (Character.isUpperCase(decryptedText.charAt(i))) {
                encrypted.append((char)((decryptedText.charAt(i) - 'A' + shift) % 26 + 'A'));
            } else if (Character.isLowerCase(decryptedText.charAt(i))) {
                encrypted.append((char)((decryptedText.charAt(i) - 'a' + shift) % 26 + 'a'));
            } else { encrypted.append(decryptedText.charAt(i)); }
        }

        return encrypted.toString();
    }

    public String decrypt(String encryptedText) {
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < encryptedText.length(); ++i) {
            if (Character.isUpperCase(encryptedText.charAt(i))) {
                decrypted.append((char)((encryptedText.charAt(i) - 'A' - shift) % 26 + 'A'));
            } else if (Character.isLowerCase(encryptedText.charAt(i))) {
                decrypted.append((char)((encryptedText.charAt(i) - 'a' - shift) % 26 + 'a'));
            } else { decrypted.append(encryptedText.charAt(i)); }
        }

        return decrypted.toString();
    }
}

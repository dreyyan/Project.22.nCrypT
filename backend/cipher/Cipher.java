package backend.cipher;

public interface Cipher {
    String encrypt(String decryptedText);
    String decrypt(String encryptedText); 
}

import java.util.Scanner;

public class CaesarCipher {

    // Method to encrypt plaintext using Caesar Cipher
    public static String encrypt(String plaintext, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        // Iterate through each character in the plaintext
        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                // Apply the Caesar Cipher shift to each letter
                char encryptedChar = (char) (base + (c - base + shift) % 26);
                encryptedText.append(encryptedChar);
            } else {
                // Keep non-letter characters unchanged
                encryptedText.append(c);
            }
        }

        // Convert StringBuilder to String and return the encrypted text
        return encryptedText.toString();
    }

    // Method to decrypt Caesar Cipher encrypted text
    public static String decrypt(String encryptedText, int shift) {
        // Decrypting is essentially encrypting with the opposite (negative) shift
        return encrypt(encryptedText, 26 - shift);
    }

    // Main method to take user input and demonstrate Caesar Cipher
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for plaintext
        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine();

        // Get user input for the shift value (key)
        System.out.print("Enter the shift value (key): ");
        int shift = scanner.nextInt();

        // Encrypt the plaintext using the provided shift
        String encryptedText = encrypt(plaintext, shift);
        System.out.println("Encrypted text: " + encryptedText);

        // Decrypt the encrypted text using the same shift
        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Decrypted text: " + decryptedText);

        // Close the Scanner to prevent resource leaks
        scanner.close();
    }
}

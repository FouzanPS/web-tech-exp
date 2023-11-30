import java.util.Scanner;

public class ColumnarTranspositionCipher {

    public static String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();
        int keyLength = key.length();
        int numRows = (int) Math.ceil((double) plaintext.length() / keyLength);
        int paddingSize = numRows * keyLength - plaintext.length();

        // Pad the plaintext with spaces if needed
        for (int i = 0; i < paddingSize; i++) {
            plaintext += " ";
        }

        // Create a 2D array for the transposition table
        char[][] transpositionTable = new char[numRows][keyLength];
        int textIndex = 0;

        // Fill the transposition table with characters from the plaintext
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < keyLength; col++) {
                transpositionTable[row][col] = plaintext.charAt(textIndex);
                textIndex++;
            }
        }

        // Create an array to store the column order based on the key
        int[] columnOrder = new int[keyLength];
        for (int i = 0; i < keyLength; i++) {
            char currentChar = key.charAt(i);
            columnOrder[i] = key.indexOf(currentChar);
        }

        // Build the ciphertext by reading the transposition table in column order
        for (int col : columnOrder) {
            for (int row = 0; row < numRows; row++) {
                ciphertext.append(transpositionTable[row][col]);
            }
        }

        return ciphertext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine();

        System.out.print("Enter the key: ");
        String key = scanner.nextLine();

        String encryptedText = encrypt(plaintext, key);
        System.out.println("Encrypted text: " + encryptedText);

        scanner.close();
    }
}

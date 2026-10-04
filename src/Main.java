import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = 123;
        while (choice != 0) {
            System.out.println("Выберите опцию\n" +
                    "1.Зашифровать текст шифром Цезаря\n" +
                    "2.Расшифровать текст шифром Цезаря\n" +
                    "3.Зашифровать текст двоичным кодом\n" +
                    "4.Расшифровать двоичный код\n" +
                    "5.Зашифровать текст кодом ASCII\n" +
                    "0.Выйти из программы");
            choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Введите текст, который хотите зашифровать(только латиница): ");
                    String text_to_encrypt = in.nextLine();
                    System.out.println("Введите ключ(число) для шифрования текста: ");
                    int key = in.nextInt();
                    System.out.println("Зашифрованный текст: " + CeaserEncrypt(text_to_encrypt, key));
                    break;

                case 2:
                    System.out.println("Введите текст, который хотите расшифровать(только латиница): ");
                    String text_to_decrypt = in.nextLine();
                    System.out.println("Введите ключ(число) для дешифровки текста: ");
                    key = in.nextInt();
                    System.out.println("Расшифрованный текст: " + CeaserDecrypt(text_to_decrypt, key));
                    break;

                case 3:
                    System.out.println("Введите текст, который хотите зашифровать(только латиница): ");
                    text_to_encrypt = in.nextLine();
                    System.out.println("Зашифрованный текст: " + BinaryEncrypt(text_to_encrypt));
                    break;

                case 4:
                    System.out.println("Введите текст, который хотите расшифровать(только латиница): ");
                    text_to_decrypt = in.nextLine();
                    System.out.println("Расшифрованный текст: " + BinaryDecrypt(text_to_decrypt));
                    break;

                case 5:
                    System.out.println("Введите текст, который хотите зашифровать(только латиница): ");
                    text_to_encrypt = in.nextLine();
                    System.out.println("Зашифрованный текст: " + ASCIIEncrypt(text_to_encrypt));
                    break;

                case 0:
                    System.out.println("Выход из программы...");
                    break;

                default:
                    System.out.println("Такой опции нет, попробуйте ещё раз");

            }
        }
    }

    public static String CeaserEncrypt(String initial_text, int key) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String encrypted_text = new String();
        int curr_index_letter;

        initial_text = initial_text.toLowerCase();

        for (char letter : initial_text.toCharArray()) {

            curr_index_letter = alphabet.indexOf(letter);
            if (letter != ' ') {
                encrypted_text = encrypted_text + alphabet.charAt((curr_index_letter + key < alphabet.length()) ?
                        curr_index_letter + key :
                        curr_index_letter + key - alphabet.length());
            }else{
                encrypted_text = encrypted_text + ' ';
            }
        }

        return encrypted_text;
    }

    public static String CeaserDecrypt(String encrypted_text, int key) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String decrypted_text = new String();
        int curr_index_letter;

        encrypted_text = encrypted_text.toLowerCase();

        for (char letter : encrypted_text.toCharArray()) {

            curr_index_letter = alphabet.indexOf(letter);
            if (letter != ' ') {
                decrypted_text = decrypted_text + alphabet.charAt((curr_index_letter - key < 0) ?
                        curr_index_letter - key + alphabet.length():
                        curr_index_letter - key);
            }else {
                decrypted_text = decrypted_text + ' ';
            }
        }

        return decrypted_text;
    }

    public static String BinaryEncrypt(String initial_text) {
        String encrypted_text = new String();

        for (char letter : initial_text.toCharArray()) {
            encrypted_text = encrypted_text + Integer.toBinaryString(letter) + ' ';
        }

        return encrypted_text.trim();
    }

    public static String BinaryDecrypt(String encrypted_text) {
        String decrypted_text = new String();

        String[] splitArray = encrypted_text.trim().split(" +");

        for (String letter : splitArray) {
            char c = (char)Integer.parseInt(letter, 2);
            decrypted_text = decrypted_text + c;
        }

        return decrypted_text;
    }

    public static String ASCIIEncrypt(String initial_text) {
        String encrypted_text = new String();

        for (char letter : initial_text.toCharArray()) {
            encrypted_text = encrypted_text + (int)letter + ' ';
        }

        return encrypted_text.trim();
    }
}
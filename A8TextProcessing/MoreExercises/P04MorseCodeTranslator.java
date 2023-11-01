package A8TextProcessing.MoreExercises;

import java.util.Scanner;

public class P04MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String[] messageArr = message.split(" \\| " );

        StringBuilder encryptedMessage = new StringBuilder();

        String[] morseCodeArr = {".-", " -...", "-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        String[] englishLettersArr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        for (String morseCode : messageArr) {
                String[] currentArr = morseCode.split("\\s+");

                for (String currStr:currentArr) {
                    for (int i = 0; i <morseCodeArr.length - 1 ; i++) {
                        if (currStr.equals(morseCodeArr[i])) {
                            encryptedMessage.append(englishLettersArr[i]);
                            break;
                        }

                    }
                }
                encryptedMessage.append(" ");
        }
        System.out.println(encryptedMessage);

    }
}

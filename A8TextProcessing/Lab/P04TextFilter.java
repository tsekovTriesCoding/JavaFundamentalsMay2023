package A8TextProcessing.Lab;

import java.util.Scanner;

public class P04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] banWordsArr = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String banWord : banWordsArr) {
            String asterisk = repeatAsterisk(banWord.length());

            text = text.replace(banWord, asterisk);
        }

        System.out.println(text);
    }

    public static String repeatAsterisk(int n) {
        String result = "";

        for (int i = 1; i <= n; i++) {
            result += "*";
        }

        return result;
    }
}

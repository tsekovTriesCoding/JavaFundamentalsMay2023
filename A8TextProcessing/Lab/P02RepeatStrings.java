package A17TextProcessing;

import java.util.Scanner;

public class P02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringArr = scanner.nextLine().split("\\s+");

        String output = "";
        for (int i = 0; i <= stringArr.length - 1; i++) {
            int n = stringArr[i].length();
            output += getRepeatedString(stringArr[i], n);
        }
        System.out.println(output);
    }

    public static String getRepeatedString(String word, int n) {

        String result = "";
        for (int i = 1; i <= n; i++) {
            result += word;
        }
        return result;
    }
}

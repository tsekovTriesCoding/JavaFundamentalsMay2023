package A4Methods.Lab;

import java.util.Scanner;

public class P07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        String output = repeatString(input, n);
        System.out.println(output);
    }

    public static String repeatString(String input, int n) {
        String repeatedString = "";
        for (int i = 1; i <= n; i++) {
            repeatedString += input;
        }
        return repeatedString;
    }
}

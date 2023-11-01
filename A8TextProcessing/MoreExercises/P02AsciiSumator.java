package A8TextProcessing.MoreExercises;

import java.util.Scanner;

public class P02AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char symbol1 = scanner.nextLine().charAt(0);
        char symbol2 = scanner.nextLine().charAt(0);
        String randomString = scanner.nextLine();

        int asciiSum = 0;
        for (int i = 0; i <= randomString.length() - 1; i++) {

            if ((randomString.charAt(i) > symbol1 && randomString.charAt(i) < symbol2) ||
                    (randomString.charAt(i) < symbol1 && randomString.charAt(i) > symbol2)) {
                asciiSum += randomString.charAt(i);
            }
        }

        System.out.println(asciiSum);
    }
}

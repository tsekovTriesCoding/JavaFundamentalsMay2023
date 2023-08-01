package A8Methods;

import java.util.Scanner;

public class P09GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputType = scanner.nextLine();

        if (inputType.equals("int")) {
            int num1 = Integer.parseInt(scanner.nextLine());
            int num2 = Integer.parseInt(scanner.nextLine());

            System.out.println(getMax(num1, num2));

        } else if (inputType.equals("char")) {
            char char1 = scanner.nextLine().charAt(0);
            char char2 = scanner.nextLine().charAt(0);

            System.out.println(getMax(char1, char2));

        } else if (inputType.equals("string")) {
            String word1 = scanner.nextLine();
            String word2 = scanner.nextLine();

            System.out.println(getMax(word1, word2));
        }
    }

    public static int getMax(int num1, int num2) {
        return Math.max(num1, num2);
    }

    public static char getMax(char char1, char char2) {
        if (char1 > char2) {
            return char1;
        }
        return char2;
    }

    public static String getMax(String word1, String word2) {
        if (word1.compareTo(word2) >= 0) {
            return word1;
        }
        return word2;
    }
}

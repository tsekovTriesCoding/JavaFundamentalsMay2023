package A4Methods.MoreExercises;

import java.util.Scanner;

public class P01DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (input.equals("int")) {
            int num = Integer.parseInt(scanner.nextLine());
            int result = multiplyBy2(num);

            System.out.println(result);
        } else if (input.equals("real")) {
            double num = Double.parseDouble(scanner.nextLine());
            String result = String.format("%.2f", multiplyBy1AndAHalf(num));

            System.out.println(result);
        } else if (input.equals("string")) {
            String word = scanner.nextLine();
            String newWord = surroundWith$(word);

            System.out.println(newWord);
        }

    }

    public static int multiplyBy2(int num) {
        return num * 2;
    }

    public static double multiplyBy1AndAHalf(double num) {
        return num * 1.5;
    }

    public static String surroundWith$(String word) {
        return "$" + word + "$";
    }
}

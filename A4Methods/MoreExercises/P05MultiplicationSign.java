package A4Methods.MoreExercises;

import java.util.Scanner;

public class P05MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        if (isZero(num1, num2, num3)) {
            System.out.println("zero");
        } else if (isPositive(num1, num2, num3)) {
            System.out.println("positive");
        } else {
            System.out.println("negative");
        }
    }

    public static boolean isPositive(int n1, int n2, int n3) {

        int negativeCounter = 0;
        if (n1 < 0) {
            negativeCounter++;
        }
        if (n2 < 0) {
            negativeCounter++;
        }

        if (n3 < 0) {
            negativeCounter++;
        }

        return negativeCounter % 2 == 0;
    }

    public static boolean isZero(int n1, int n2, int n3) {

        int zeroCounter = 0;
        if (n1 == 0) {
            zeroCounter++;
        } else if (n2 == 0) {
            zeroCounter++;
        } else if (n3 == 0) {
            zeroCounter++;
        }

        return zeroCounter > 0;
    }
}

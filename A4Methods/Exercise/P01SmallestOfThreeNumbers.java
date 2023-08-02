package A9ExerciseMethods.Exercises;

import java.util.Scanner;

public class P01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        printSmallestNum(num1, num2, num3);
    }

    public static void printSmallestNum(int num1, int num2, int num3) {

        int result = Math.min(Math.min(num1, num2), num3);

        System.out.println(result);
    }
}

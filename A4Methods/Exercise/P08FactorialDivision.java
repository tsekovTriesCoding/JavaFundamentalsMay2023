package A4Methods.Exercise;

import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        double result = calculateFactorial(num1) * 1.0 / calculateFactorial(num2);

        System.out.printf("%.2f", result);
    }

    public static long calculateFactorial(int num) {

        long factorial = 1;
        for (int i = 1; i <= num; i++) {

            factorial = factorial * i;
        }
        return factorial;
    }
}

package A8Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int num2 = Integer.parseInt(scanner.nextLine());

        DecimalFormat df = new DecimalFormat("0.##");
        double result = calculate(num1, operator, num2);
        System.out.println(df.format(result));
    }

    public static double calculate(int num1, String operator, int num2) {
        double result = 0;

        switch (operator) {
            case "/":
                result = num1 * 1.0 / num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;

        }

        return result;
    }
}

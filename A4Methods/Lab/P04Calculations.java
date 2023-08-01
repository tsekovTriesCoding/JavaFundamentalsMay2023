package A8Methods;

import java.util.Scanner;

public class P04Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        switch (operation) {
            case "add":
                printAdd(num1, num2);
                break;
            case "multiply":
                printMultiply(num1, num2);
                break;
            case "subtract":
                printSubtract(num1, num2);
                break;
            case "divide":
                printDivide(num1, num2);
                break;

        }
    }
    public static void printAdd(int n1, int n2) {
        System.out.println(n1 + n2);
    }

    public static void printMultiply(int n1, int n2) {
        System.out.println(n1 * n2);
    }

    public static void printSubtract(int n1, int n2) {
        System.out.println(n1 - n2);
    }

    public static void printDivide(int n1, int n2) {
        System.out.println(n1 / n2);
    }
}

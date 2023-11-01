package A1BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class P08TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int rows = 1; rows <= num ; rows++) {
            for (int cols = 1; cols <= rows ; cols++) {

                System.out.print(rows);
                if (cols < rows) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

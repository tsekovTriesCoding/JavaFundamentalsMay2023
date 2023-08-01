package A6ExerciseArrays.MoreExercises;

import java.util.Scanner;

public class P02PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        long[][] numbers = new long[n][];

        numbers[0] = new long[1];
        numbers[0][0] = 1;

        for (int row = 0; row < n; row++) {
            numbers[row] = new long[row + 1];
            numbers[row][0] = 1;
            numbers[row][row] = 1;
            for (int col = 1; col < row; col++) {

                numbers[row][col] = numbers[row - 1][col - 1] + numbers[row - 1][col];
            }

        }
        for (int i = 0; i < n; i++) {
            for (long currentNum : numbers[i]) {

                System.out.print(currentNum);
                System.out.print(" ");

            }

            System.out.println();
        }
    }
}

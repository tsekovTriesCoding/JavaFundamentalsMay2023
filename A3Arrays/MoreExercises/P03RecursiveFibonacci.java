package A3Arrays.MoreExercises;

import java.util.Scanner;

public class P03RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] fibonacci = new int[n + 1];

        fibonacci[0] = 1;
        int f0 = 0;
        int f1 = 1;

        for (int i = 0; i < n; i++) {
            int nF = f0 + f1;
            f0 = f1;
            f1 = nF;
            fibonacci[i + 1] = f1;
        }

        System.out.print(fibonacci[fibonacci.length - 2]);
    }
}

package A9ExerciseMethods.MoreExercises;

import java.util.Scanner;

public class P04TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int[] tribonacciSequence = tribonnaciSequence(num + 2);

        for (int i = 2; i <= tribonacciSequence.length - 3; i++) {
            System.out.print(tribonacciSequence[i] + " ");
        }
    }

    public static int[] tribonnaciSequence(int num) {

        int[] tribonnaciSequence = new int[num + 2];
        tribonnaciSequence[0] = tribonnaciSequence[1] = 0;
        tribonnaciSequence[2] = 1;

        for (int i = 3; i < num ; i++) {
            tribonnaciSequence[i] = tribonnaciSequence[i - 1] +
                    tribonnaciSequence[i - 2] +
                    tribonnaciSequence[i - 3];
        }

        return tribonnaciSequence;
    }
}

package A3Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P06EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray1 = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] numbersArray2 = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        boolean areEqual = true;
        int diffIndex = -1;
        for (int i = 0; i <= numbersArray1.length - 1; i++) {
            int firstNum = numbersArray1[i];
            int secondNum = numbersArray2[i];
            if (firstNum == secondNum) {
                sum += firstNum;
            } else {
                areEqual = false;
                diffIndex = i;
                break;
            }
        }

        if (areEqual) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", diffIndex);
        }
    }
}

package A5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P03SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int evenNumsSum = 0;
        for (int i = 0; i <= numbersArray.length - 1; i++) {
            if (numbersArray[i] % 2 == 0) {
                evenNumsSum += numbersArray[i];
            }
        }
        System.out.println(evenNumsSum);
    }
}

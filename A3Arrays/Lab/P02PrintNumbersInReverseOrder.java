package A5Arrays;

import java.util.Scanner;

public class P02PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numbersArray = new int[n];

        for (int i = 0; i < n; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            numbersArray[i] = currentNumber;
        }

        for (int i = numbersArray.length - 1; i >= 0; i--) {
            System.out.print(numbersArray[i] + " ");
        }

    }
}

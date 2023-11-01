package A3Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P07CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        while (numbers.length > 1) {
            int[] condensedNums = new int[numbers.length - 1];
            for (int i = 0; i < numbers.length - 1; i++) {

                condensedNums[i] = numbers[i] + numbers[i + 1];


            }
            numbers = condensedNums;
        }
        sum = Arrays.stream(numbers).sum();
        System.out.println(sum);
    }
}

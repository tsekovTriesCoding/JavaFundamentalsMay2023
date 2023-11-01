package A3Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P08MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int magicNum = Integer.parseInt(scanner.nextLine());

        for (int index = 0; index <= numbers.length - 1; index++) {
            for (int nextIndex = index + 1; nextIndex <= numbers.length - 1; nextIndex++) {
                if (numbers[index] + numbers[nextIndex] == magicNum) {
                    System.out.print(numbers[index] + " " + numbers[nextIndex]);
                    System.out.println();
                    break;
                }
            }
        }
    }
}

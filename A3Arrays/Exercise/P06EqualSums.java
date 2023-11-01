package A3Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean areEqual = false;
        int equalSumsIndex = 0;

        for (int index = 0; index <= numbers.length - 1; index++) {
            int leftSum = 0;
            int rightSum = 0;

            if (index > 0) {
                for (int indexLeftNum = 0; indexLeftNum <= index - 1; indexLeftNum++) {
                    leftSum += numbers[indexLeftNum];
                }
            }
            for (int indexRightNum = index + 1; indexRightNum <= numbers.length - 1; indexRightNum++) {
                rightSum += numbers[indexRightNum];
            }


            if (leftSum == rightSum) {
                areEqual = true;
                equalSumsIndex = index;
                break;
            }
        }

        if (areEqual) {
            System.out.println(equalSumsIndex);
        } else {
            System.out.println("no");
        }
    }
}

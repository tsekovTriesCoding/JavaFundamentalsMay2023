package A6ExerciseArrays.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P04LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] len = new int[numbers.length];
        int[] prev = new int[numbers.length];

        int maxLength = 0;
        int lastIndex = -1;
        for (int i = 0; i < numbers.length; i++) {
            len[i] = 1;
            prev[i] = -1;

            for (int k = 0; k < i; k++) {
                if (numbers[k] < numbers[i] && len[k] + 1 > len[i]) {
                    len[i] = len[k] + 1;
                    prev[i] = k;
                }
            }

            if (len[i] > maxLength) {
                maxLength = len[i];
                lastIndex = i;
            }
        }

        int[] lis = new int[maxLength];
        int currentIndex = maxLength - 1;

        while (lastIndex != -1)  {
            lis[currentIndex] = numbers[lastIndex];
            currentIndex--;
            lastIndex = prev[lastIndex];
        }
        for(int index = 0; index < lis.length; index++){
            System.out.print(lis[index] + " ");
        }

    }
}

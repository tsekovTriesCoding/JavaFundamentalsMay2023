package A6ExerciseArrays.MoreExercises;

import java.util.*;

public class P05KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        int bestLength = 1;
        int bestStartIndex = 0;
        int bestDnaSum = 0;
        int dnaCounter = 0;
        int bestDnaIndex = 0;
        int[] winnerDna = new int[n];
        while (!input.equals("Clone them!")) {
            int[] dnaSequence = Arrays
                    .stream(input.split("!+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            dnaCounter++;

            int length = 1;
            int bestCurrentLength = 1;
            int startIndex = 0;
            int currentDnaSum = 0;
            for (int i = 0; i < dnaSequence.length - 1; i++) {
                if (dnaSequence[i] == dnaSequence[i + 1]) {
                    length++;
                } else {
                    length = 1;
                }

                if (length > bestCurrentLength) {
                    bestCurrentLength = length;
                    startIndex = i;
                }

                currentDnaSum += dnaSequence[i];
            }
            currentDnaSum += dnaSequence[n - 1];

            if (bestCurrentLength > bestLength) {
                bestLength = bestCurrentLength;
                bestStartIndex = startIndex;
                bestDnaSum = currentDnaSum;
                bestDnaIndex = dnaCounter;
                winnerDna = dnaSequence;
            } else if (bestCurrentLength == bestLength) {
                if (startIndex < bestStartIndex) {
                    bestLength = bestCurrentLength;
                    bestStartIndex = startIndex;
                    bestDnaSum = currentDnaSum;
                    bestDnaIndex = dnaCounter;
                    winnerDna = dnaSequence;
                } else if (startIndex == bestStartIndex) {
                    if (currentDnaSum > bestDnaSum) {
                        bestLength = bestCurrentLength;
                        bestStartIndex = startIndex;
                        bestDnaSum = currentDnaSum;
                        bestDnaIndex = dnaCounter;
                        winnerDna = dnaSequence;
                    }
                }
            }

            input = scanner.nextLine();
        }


        System.out.printf("Best DNA sample %d with sum: %d.%n", bestDnaIndex, bestDnaSum);

        for (int i : winnerDna) {
            System.out.print(i + " ");

        }

    }

}

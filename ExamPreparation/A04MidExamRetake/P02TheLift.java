package ExamPreparation.A04MidExamRetake;

import java.util.Arrays;
import java.util.Scanner;

public class P02TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleWaiting = Integer.parseInt(scanner.nextLine());

        int[] wagons = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i <= wagons.length - 1; i++) {

            while (wagons[i] < 4 && peopleWaiting > 0) {
                wagons[i]++;
                peopleWaiting--;
            }

        }

        boolean hasEmptySpots = false;
        for (int element : wagons) {
            if (element < 4) {
                hasEmptySpots = true;
                break;
            }
        }
        if (peopleWaiting == 0 && hasEmptySpots) {
            System.out.println("The lift has empty spots!");
        } else if (peopleWaiting > 0 && !hasEmptySpots) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
        }

        System.out.println(Arrays.toString(wagons)
                .replaceAll("[\\[\\],]", ""));

    }
}

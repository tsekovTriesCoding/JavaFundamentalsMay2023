package ExamPreparation.A07MidExam;

import java.util.Arrays;
import java.util.Scanner;

public class P03HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] neighborhood = Arrays
                .stream(scanner.nextLine().split("@"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();
        int lastPosition = 0;

        while (!command.equals("Love!")) {
            int jumpLength = Integer.parseInt(command.split(" ")[1]);

            for (int i = lastPosition; i <= neighborhood.length - 1; i++) {
                int indexToJumpTo = i + jumpLength;

                if (indexToJumpTo > neighborhood.length - 1) {
                    indexToJumpTo = 0;
                }

                if (neighborhood[indexToJumpTo] == 0) {
                    System.out.printf("Place %d already had Valentine's day.%n", indexToJumpTo);
                } else {
                    neighborhood[indexToJumpTo] -= 2;

                    if (neighborhood[indexToJumpTo] == 0) {
                        System.out.printf("Place %d has Valentine's day.%n", indexToJumpTo);
                    }
                }

                lastPosition = indexToJumpTo;
                break;
            }

            command = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", lastPosition);

        boolean successful = true;
        for (int element : neighborhood) {

            if (element != 0) {
                successful = false;
                break;
            }
        }

        if (successful) {
            System.out.println("Mission was successful.");
        } else {

            int housesWithNoValentine = 0;
            for (int element : neighborhood) {
                if (element > 0) {
                    housesWithNoValentine++;
                }
            }
            System.out.printf("Cupid has failed %d places.", housesWithNoValentine);
        }
    }
}

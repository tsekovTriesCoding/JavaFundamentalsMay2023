package ExamPreparation.A5ExamRetake;

import java.util.Arrays;
import java.util.Scanner;

public class P02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();
        int shotTargets = 0;

        while (!command.equals("End")) {

            int index = Integer.parseInt(command);

            if (index >= 0 && index <= targets.length - 1) {
                int shotTarget = targets[index];

                if (targets[index] != -1) {
                    targets[index] = -1;
                    shotTargets++;

                    for (int i = 0; i <= targets.length - 1; i++) {
                        if (targets[i] > shotTarget && targets[i] != -1) {
                            targets[i] -= shotTarget;

                        } else if (targets[i] <= shotTarget && targets[i] != -1) {
                            targets[i] += shotTarget;

                        }
                    }
                }

            }
            command = scanner.nextLine();
        }

        System.out.printf("Shot targets: %d -> ", shotTargets);
        System.out.println(Arrays.toString(targets).replaceAll("[\\[\\],]", ""));

    }
}

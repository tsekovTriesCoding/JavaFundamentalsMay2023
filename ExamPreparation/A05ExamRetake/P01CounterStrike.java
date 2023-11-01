package ExamPreparation.A05ExamRetake;

import java.util.Scanner;

public class P01CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        boolean notEnoughEnergy = false;
        int wonBattles = 0;

        while (!command.equals("End of battle")) {
            int distance = Integer.parseInt(command);

            if (initialEnergy >= distance) {
                wonBattles++;
                initialEnergy -= distance;
            } else {
                notEnoughEnergy = true;
                break;
            }

            if (wonBattles % 3 == 0) {
                initialEnergy += wonBattles;
            }

            command = scanner.nextLine();
        }

        if (notEnoughEnergy) {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy"
                    , wonBattles, initialEnergy);
        } else {
            System.out.printf("Won battles: %d. Energy left: %d", wonBattles, initialEnergy);
        }
    }
}

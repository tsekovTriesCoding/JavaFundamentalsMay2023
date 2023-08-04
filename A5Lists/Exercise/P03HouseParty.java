package A11ExerciseList.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        List<String> guests = new ArrayList<>();

        for (int i = 1; i <= numberOfCommands; i++) {
            String input = scanner.nextLine();
            String nameOfGuest = (input.split(" ")[0]);

            if (input.contains("not going")) {
                if (guests.contains(nameOfGuest)) {

                    guests.remove(nameOfGuest);

                } else {
                    System.out.printf("%s is not in the list!%n", nameOfGuest);
                }

            } else if (input.contains("going")) {
                if (!guests.contains(nameOfGuest)) {

                    guests.add(nameOfGuest);

                } else {
                    System.out.printf("%s is already in the list!%n", nameOfGuest);
                }
            }
        }

        for (String name : guests) {
            System.out.println(name);
        }
    }
}

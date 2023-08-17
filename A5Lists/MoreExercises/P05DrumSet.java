package A11ExerciseList.MoreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> drumSet = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> initialDrumSet = new java.util.ArrayList<>(List.copyOf(drumSet));

        String command = scanner.nextLine();

        while (!command.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(command);

            for (int i = 0; i <= drumSet.size() - 1; i++) {
                int currentQuality = drumSet.get(i);
                int newQuality = currentQuality - hitPower;

                drumSet.set(i, newQuality);

                if (drumSet.get(i) <= 0) {

                    if (savings >= initialDrumSet.get(i) * 3) {
                        savings -= initialDrumSet.get(i) * 3;
                        drumSet.set(i, initialDrumSet.get(i));
                    } else {
                        drumSet.remove(i);
                        initialDrumSet.remove(i);
                       if (i <= drumSet.size() - 1) {
                           i--;
                       }
                    }
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(drumSet.toString()
                .replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}

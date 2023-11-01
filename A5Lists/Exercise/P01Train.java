package A5Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int wagonMaxCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            if (command.contains("Add")) {
                int passengers = Integer.parseInt(command.split(" ")[1]);

                wagons.add(passengers);

            } else {
                int passengersToAdd = Integer.parseInt(command.split(" ")[0]);

                for (int i = 0; i <= wagons.size() - 1; i++) {
                    if (wagonMaxCapacity - wagons.get(i) >= passengersToAdd) {
                        wagons.set(i, (wagons.get(i) + passengersToAdd));
                        break;
                    }
                }

            }
            command = scanner.nextLine();
        }

        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}

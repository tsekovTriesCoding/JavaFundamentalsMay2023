package ExamPreparation.A6FinalExamRetake;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> carsWithMileage = new LinkedHashMap<>();
        Map<String, Integer> carsWithFuel = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\|");

            String car = tokens[0];
            int mileage = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);

            carsWithMileage.putIfAbsent(car, mileage);
            carsWithFuel.putIfAbsent(car, fuel);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String command = input.split(" : ")[0];
            String car = input.split(" : ")[1];

            switch (command) {
                case "Drive":
                    drive(carsWithMileage, carsWithFuel, input, car);
                    break;
                case "Refuel":
                    refuel(carsWithFuel, input, car);
                    break;
                case "Revert":
                    revert(carsWithMileage, input, car);
                    break;
            }

            input = scanner.nextLine();
        }

        carsWithMileage.forEach((car, mileage) -> {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", car, mileage, carsWithFuel.get(car));
        });
    }

    private static void revert(Map<String, Integer> carsWithMileage, String input, String car) {
        int kilometers = Integer.parseInt(input.split(" : ")[2]);

        carsWithMileage.put(car, carsWithMileage.get(car) - kilometers);

        if (carsWithMileage.get(car) < 10000) {
            carsWithMileage.put(car, 10000);
        } else {
            System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
        }
    }

    private static void refuel(Map<String, Integer> carsWithFuel, String input, String car) {
        int fuel;
        fuel = Integer.parseInt(input.split(" : ")[2]);
        int fuelFilled = 0;

        if (carsWithFuel.get(car) + fuel > 75) {
            fuelFilled = 75 - carsWithFuel.get(car);
            carsWithFuel.put(car, 75);
        } else {
            carsWithFuel.put(car, carsWithFuel.get(car) + fuel);
            fuelFilled = fuel;
        }

        System.out.printf("%s refueled with %d liters%n", car, fuelFilled);
    }

    private static void drive(Map<String, Integer> carsWithMileage, Map<String, Integer> carsWithFuel, String input, String car) {
        int distance = Integer.parseInt(input.split(" : ")[2]);
        int fuel = Integer.parseInt(input.split(" : ")[3]);

        if (carsWithFuel.get(car) < fuel) {
            System.out.println("Not enough fuel to make that ride");
        } else {
            carsWithMileage.put(car, carsWithMileage.get(car) + distance);
            carsWithFuel.put(car, carsWithFuel.get(car) - fuel);

            System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
        }

        if (carsWithMileage.get(car) >= 100000) {
            carsWithMileage.remove(car);
            carsWithFuel.remove(car);

            System.out.printf("Time to sell the %s!%n", car);
        }
    }
}

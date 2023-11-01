package A6ObjectsAndClasses.Exercise.P05VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> carsList = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String typeOfVehicle = input.split("\\s+")[0];
            String model = input.split("\\s+")[1];
            String color = input.split("\\s+")[2];
            int horsePower = Integer.parseInt(input.split("\\s+")[3]);

            Vehicle vehicle = new Vehicle(typeOfVehicle, model, color, horsePower);

            carsList.add(vehicle);

            input = scanner.nextLine();
        }

        String input2 = scanner.nextLine();

        while (!input2.equals("Close the Catalogue")) {

            String modelOfVehicle = input2;

            printVehicleData(carsList, modelOfVehicle);

            input2 = scanner.nextLine();
        }

        int totalCarsHp = 0;
        int totalTrucksHp = 0;
        int carsCount = 0;
        int trucksCount = 0;

        for (Vehicle vehicle : carsList) {

            if (vehicle.getTypeOfVehicle().equals("car")) {
                carsCount++;
                totalCarsHp += vehicle.getHorsePower();
            } else {
                trucksCount++;
                totalTrucksHp += vehicle.getHorsePower();
            }
        }

        double avgCarHorsepower = totalCarsHp * 1.0 / carsCount;
        double avgTruckHorsepower = totalTrucksHp * 1.0 / trucksCount;

        if (totalTrucksHp == 0) {
            avgTruckHorsepower = 0;
        } else if (totalCarsHp == 0) {
            avgCarHorsepower = 0;
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n", avgCarHorsepower);
        System.out.printf("Trucks have average horsepower of: %.2f.", avgTruckHorsepower);

    }

    private static void printVehicleData(List<Vehicle> carsList, String modelOfVehicle) {
        for (Vehicle vehicle : carsList) {
            if (vehicle.getModel().equals(modelOfVehicle)) {

                String withCapLetter = vehicle.getTypeOfVehicle().substring(0,1).toUpperCase()
                        + vehicle.getTypeOfVehicle().substring(1);
                System.out.println("Type: " + withCapLetter);
                System.out.println("Model: " + vehicle.getModel());
                System.out.println("Color: " + vehicle.getColor());
                System.out.println("Horsepower: " + vehicle.getHorsePower());
            }
        }
    }
}

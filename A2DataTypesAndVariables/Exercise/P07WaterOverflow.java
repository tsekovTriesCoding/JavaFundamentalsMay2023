package A4ExerciseDataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tankCapacity = 255;
        int n = Integer.parseInt(scanner.nextLine());//number of lines

        int currentCapacity = 0;

        for (int i = 1; i <= n; i++) {
            int waterQuantity = Integer.parseInt(scanner.nextLine());

            if (waterQuantity > tankCapacity) {
                System.out.println("Insufficient capacity!");
            } else {
                tankCapacity -= waterQuantity;
                currentCapacity += waterQuantity;
            }
        }

        System.out.println(currentCapacity);
    }
}

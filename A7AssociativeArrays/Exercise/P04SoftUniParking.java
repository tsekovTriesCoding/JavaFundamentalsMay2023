package A16AssociativeArraysAndLambdaAndStreamAPI.Exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P04SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, String> registeredPlatesMap = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();
            String username = command.split("\\s+")[1];

            if (command.split("\\s+")[0].equals("register")) {
                String licencePlate = command.split("\\s+")[2];

                if (!registeredPlatesMap.containsKey(username)) {
                    registeredPlatesMap.put(username, licencePlate);
                    System.out.printf("%s registered %s successfully%n", username, licencePlate);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", licencePlate);
                }
            } else if (command.split("\\s+")[0].equals("unregister")) {
                if (!registeredPlatesMap.containsKey(username)) {
                    System.out.printf("ERROR: user %s not found%n", username);
                } else {
                    registeredPlatesMap.remove(username);
                    System.out.printf("%s unregistered successfully%n", username);
                }
            }

        }

        registeredPlatesMap.forEach((key, value) -> System.out.println(key + " => " + value));
    }
}

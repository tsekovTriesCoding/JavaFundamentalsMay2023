package A7AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        LinkedHashMap<String, Integer> resourcesMap = new LinkedHashMap<>();

        while (!command.equals("stop")) {
            String resource = command;
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resourcesMap.containsKey(resource)) {
                resourcesMap.put(resource, quantity);
            } else {
                int currentQuantity = resourcesMap.get(resource);
                resourcesMap.put(resource, currentQuantity + quantity);
            }

            command = scanner.nextLine();
        }

        resourcesMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}

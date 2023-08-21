package A16AssociativeArraysAndLambdaAndStreamAPI.Exercise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class P09ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, List<String>> sidesMap = new LinkedHashMap<>();

        while (!input.equals("Lumpawaroo")) {

            if (input.contains("|")) {
                String forceSide = input.split(" \\| ")[0];
                String forceUser = input.split(" \\| ")[1];

                if (!sidesMap.containsKey(forceSide)) {
                    sidesMap.put(forceSide, new ArrayList<>());
                }
                    boolean playerExists = false;
                    for (List<String> list : sidesMap.values()) {
                        if (list.contains(forceUser)) {
                            playerExists = true;
                            break;
                        }
                    }

                    if (!playerExists) {
                        sidesMap.get(forceSide).add(forceUser);
                    }
            } else if (input.contains("->")) {
                String forceUser = input.split(" -> ")[0];
                String forceSide = input.split(" -> ")[1];

                sidesMap.entrySet().forEach(entry -> entry.getValue().remove(forceUser));

                if (sidesMap.containsKey(forceSide)) {
                    List<String> currentPlayers = sidesMap.get(forceSide);
                    currentPlayers.add(forceUser);
                } else {
                    sidesMap.put(forceSide, new ArrayList<>());
                    sidesMap.get(forceSide).add(forceUser);
                }

                System.out.printf("%s joins the %s side!\n", forceUser, forceSide);
            }

            input = scanner.nextLine();
        }

        sidesMap.entrySet()
                .stream().filter(entry -> entry.getValue().size() > 0)
                .forEach(entry -> {
                    System.out.println("Side: " + entry.getKey() + ", Members: " + entry.getValue().size());
                    entry.getValue().forEach(user -> System.out.println("! " + user));
                });
    }
}

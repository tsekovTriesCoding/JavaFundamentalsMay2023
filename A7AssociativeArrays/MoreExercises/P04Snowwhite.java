package A16AssociativeArraysAndLambdaAndStreamAPI.MoreExercise;

import java.util.*;

public class P04Snowwhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> dwarfsMap = new TreeMap<>();
        while (!input.equals("Once upon a time")) {
            String[] tokens = input.split(" <:> ");
            String dwarfName = tokens[0];
            String dwarfHatColor = tokens[1];
            int dwarfPhysics = Integer.parseInt(tokens[2]);

            if (!dwarfsMap.containsKey(dwarfHatColor)) {
                Map<String, Integer> newMap = new LinkedHashMap<>();
                newMap.put(dwarfName, dwarfPhysics);
                dwarfsMap.put(dwarfHatColor, newMap);
            } else {
                if (!dwarfsMap.get(dwarfHatColor).containsKey(dwarfName)) {
                    dwarfsMap.get(dwarfHatColor).put(dwarfName, dwarfPhysics);
                } else {
                    boolean newDwarfIsBigger = false;
                    Map<String, Integer> currentMap = dwarfsMap.get(dwarfHatColor);
                    for (int height : currentMap.values()) {
                        if (height < dwarfPhysics) {
                            newDwarfIsBigger = true;
                            break;
                        }
                    }

                    if (newDwarfIsBigger) {
                        currentMap.put(dwarfName, dwarfPhysics);
                    }
                }
            }
            input = scanner.nextLine();
        }

    }
}

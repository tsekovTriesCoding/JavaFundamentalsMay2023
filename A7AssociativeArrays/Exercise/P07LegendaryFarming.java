package A7AssociativeArrays.Exercise;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class P07LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> keyMaterials = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> junks = new LinkedHashMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        boolean win = false;
        while (!win) {
            String[] input = scanner.nextLine().split("\\s+");

            for (int index = 0; index <= input.length - 1; index += 2) {
                int quantity = Integer.parseInt(input[index]);
                String item = input[index + 1].toLowerCase();

                if (item.equals("shards") || item.equals("fragments") || item.equals("motes")) {
                    int currentQuantity = keyMaterials.get(item);
                    keyMaterials.put(item, currentQuantity + quantity);
                } else {
                    if (junks.containsKey(item)) {
                        int currentQuantity = junks.get(item);
                        junks.put(item, currentQuantity + quantity);
                    } else {
                        junks.put(item, quantity);
                    }
                }

                if (keyMaterials.get("shards") >= 250) {
                    System.out.println("Shadowmourne obtained!");
                    win = true;
                    int currentValue = keyMaterials.get("shards");
                    keyMaterials.put("shards", currentValue - 250);
                    break;
                } else if (keyMaterials.get("fragments") >= 250) {
                    System.out.println("Valanyr obtained!");
                    win = true;
                    int currentValue = keyMaterials.get("fragments");
                    keyMaterials.put("fragments", currentValue - 250);
                    break;
                } else if (keyMaterials.get("motes") >= 250) {
                    System.out.println("Dragonwrath obtained!");
                    win = true;
                    int currentValue = keyMaterials.get("motes");
                    keyMaterials.put("motes", currentValue - 250);
                    break;
                }
            }
        }

        keyMaterials.forEach((key, value) -> System.out.println(key + ": " + value));

        junks.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}

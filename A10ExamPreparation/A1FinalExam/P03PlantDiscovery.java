package A10ExamPreparation.A1FinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantsRarity = new LinkedHashMap<>();
        Map<String, Double> plantsRatings = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String plant = input.split("<->")[0];
            int rarity = Integer.parseInt(input.split("<->")[1]);

            plantsRarity.put(plant, rarity);
            plantsRatings.put(plant, 0.0);
        }

        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            String[] tokens = input.split(": ");
            String plant = tokens[1].split(" - ")[0];

            if (plantsRarity.containsKey(plant)) {
                if (input.startsWith("Rate")) {
                    rate(plantsRatings, tokens, plant);
                } else if (input.startsWith("Update")) {
                    update(plantsRarity, tokens, plant);
                } else if (input.startsWith("Reset")) {
                    plantsRatings.put(plant, 0.0);
                }
            } else {
                System.out.println("error");
            }

            input = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");

        plantsRarity.forEach((plant, rarity) -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", plant, rarity, plantsRatings.get(plant)));
    }

    private static void update(Map<String, Integer> plantsRarity, String[] tokens, String plant) {
        int newRarity = Integer.parseInt(tokens[1].split(" - ")[1]);
        plantsRarity.put(plant, newRarity);
    }

    private static void rate(Map<String, Double> plantsRatings, String[] tokens, String plant) {
        double rating = Double.parseDouble(tokens[1].split(" - ")[1]);

        if (plantsRatings.get(plant) == 0) {
            plantsRatings.put(plant, rating);
        } else {
            double newRating = (plantsRatings.get(plant) + rating) / 2;
            plantsRatings.put(plant, newRating);
        }
    }
}

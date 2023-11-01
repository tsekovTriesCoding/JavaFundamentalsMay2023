package A10ExamPreparation.A10FinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> citiesPopulation = new LinkedHashMap<>();
        Map<String, Integer> citiesGold = new LinkedHashMap<>();
        while (!input.equals("Sail")) {
            addCity(input, citiesPopulation, citiesGold);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {
            String town = input.split("=>")[1];

            if (input.startsWith("Plunder")) {
                plunder(input, citiesPopulation, citiesGold, town);
            } else if (input.startsWith("Prosper")) {
                prosper(input, citiesGold, town);
            }

            input = scanner.nextLine();
        }

        if (citiesPopulation.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", citiesPopulation.keySet().size());
            for (Map.Entry<String, Integer> city : citiesPopulation.entrySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", city.getKey(), city.getValue(),
                        citiesGold.get(city.getKey()));
            }
        }
    }

    private static void prosper(String input, Map<String, Integer> citiesGold, String town) {
        int gold = Integer.parseInt(input.split("=>")[2]);

        if (gold < 0) {
            System.out.println("Gold added cannot be a negative number!");
        } else {
            citiesGold.put(town, citiesGold.get(town) + gold);

            System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, citiesGold.get(town));
        }
    }

    private static void plunder(String input, Map<String, Integer> citiesPopulation, Map<String, Integer> citiesGold, String town) {
        int people = Integer.parseInt(input.split("=>")[2]);
        int gold = Integer.parseInt(input.split("=>")[3]);

        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);

        citiesPopulation.put(town, citiesPopulation.get(town) - people);
        citiesGold.put(town, citiesGold.get(town) - gold);

        if (citiesPopulation.get(town) == 0 || citiesGold.get(town) == 0) {
            citiesPopulation.remove(town);
            citiesGold.remove(town);

            System.out.printf("%s has been wiped off the map!%n", town);
        }
    }

    private static void addCity(String input, Map<String, Integer> citiesPopulation, Map<String, Integer> citiesGold) {
        String city = input.split("\\|\\|")[0];
        int population = Integer.parseInt(input.split("\\|\\|")[1]);
        int gold = Integer.parseInt(input.split("\\|\\|")[2]);

        if (!citiesPopulation.containsKey(city)) {
            citiesPopulation.put(city, population);
            citiesGold.put(city, gold);
        } else {
            citiesPopulation.put(city, citiesPopulation.get(city) + population);
            citiesGold.put(city, citiesGold.get(city) + gold);
        }
    }
}

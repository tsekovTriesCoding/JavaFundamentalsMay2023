package A20ExerciseRegularExpressions.Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String starLettersRegex = "[SsAaTtRr]";
        Pattern starPattern = Pattern.compile(starLettersRegex);

        String regex = "@(?<planetName>[A-Za-z]+)[^@\\-!:>]*:(?<population>[0-9]+)[^@\\-!:>]*!(?<attackType>[A-Z])![^@\\-!:>]*->(?<soldierCount>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        List<String> attackedPlanetsList = new ArrayList<>();
        List<String> destroyedPlanetsList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();

            StringBuilder decryptedMessageSb = new StringBuilder();
            int starLettersCount = 0;
            Matcher starMatcher = starPattern.matcher(input);

            while (starMatcher.find()) {
                starLettersCount++;
            }

            String planetData = getPlanetData(input, decryptedMessageSb, starLettersCount);
            Matcher matcher = pattern.matcher(planetData);

            if (matcher.find()) {
                String planetName = matcher.group("planetName");
                String attackType = matcher.group("attackType");

                if (attackType.equals("A")) {
                    attackedPlanetsList.add(planetName);
                } else if (attackType.equals("D")) {
                    destroyedPlanetsList.add(planetName);
                }
            }

        }

        Collections.sort(attackedPlanetsList);
        Collections.sort(destroyedPlanetsList);

        System.out.printf("Attacked planets: %d%n", attackedPlanetsList.size());

        if (attackedPlanetsList.size() > 0) {
            attackedPlanetsList.forEach(planet -> System.out.println("-> " + planet));
        }

        System.out.printf("Destroyed planets: %d%n", destroyedPlanetsList.size());

        if (destroyedPlanetsList.size() > 0) {
            destroyedPlanetsList.forEach(planet -> System.out.println("-> " + planet));
        }
    }

    private static String getPlanetData(String input, StringBuilder decryptedMessageSb, int starLettersCount) {
        for (int index = 0; index < input.length() - 1; index++) {
            char newChar = (char) (input.charAt(index) - starLettersCount);
            decryptedMessageSb.append(newChar);
        }

        return decryptedMessageSb.toString();
    }

}

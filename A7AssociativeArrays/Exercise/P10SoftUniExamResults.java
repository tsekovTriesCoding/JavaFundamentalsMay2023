package A7AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, Integer> usersMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> languagesMap = new LinkedHashMap<>();

        while (!input.equals("exam finished")) {
            if (!input.contains("banned")) {
                String username = input.split("-")[0];
                String language = input.split("-")[1];
                int points = Integer.parseInt(input.split("-")[2]);

                if (!usersMap.containsKey(username)) {
                    usersMap.put(username, points);
                } else {
                    int currentPoints = usersMap.get(username);
                    if (points > currentPoints){
                        usersMap.put(username, points);
                    }
                }

                if (languagesMap.containsKey(language)) {
                    int currentCount = languagesMap.get(language);
                    languagesMap.put(language, currentCount + 1);
                } else {
                    languagesMap.put(language, 1);
                }
            } else {
                String username = input.split("-")[0];
                usersMap.entrySet().removeIf(entry -> entry.getKey().equals(username));
            }

            input = scanner.nextLine();
        }

        System.out.println("Results:");
        usersMap.entrySet().forEach(entry -> System.out.printf("%s | %d\n", entry.getKey(), entry.getValue()));
        System.out.println("Submissions:");
        languagesMap.entrySet().forEach(entry -> System.out.printf("%s - %d\n", entry.getKey(), entry.getValue()));
    }
}

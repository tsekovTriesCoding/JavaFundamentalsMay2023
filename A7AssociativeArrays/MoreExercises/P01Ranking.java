package A16AssociativeArraysAndLambdaAndStreamAPI.MoreExercise;

import java.util.*;

public class P01Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, String> contestsMap = new LinkedHashMap<>();

        while (!input.equals("end of contests")) {

            String contest = input.split(":")[0];
            String password = input.split(":")[1];

            contestsMap.put(contest, password);

            input = scanner.nextLine();
        }

        String input2 = scanner.nextLine();

        Map<String, LinkedHashMap<String, Integer>> rankingsMap = new TreeMap<>();

        while (!input2.equals("end of submissions")) {
            String contest = input2.split("=>")[0];
            String password = input2.split("=>")[1];
            String username = input2.split("=>")[2];
            int points = Integer.parseInt(input2.split("=>")[3]);

            if (contestsMap.containsKey(contest)) {
                if (contestsMap.get(contest).equals(password)) {

                    LinkedHashMap<String, Integer> currentList = new LinkedHashMap<>();
                    currentList.put(contest, points);

                    if (!rankingsMap.containsKey(username)) {
                        rankingsMap.put(username, currentList);
                    } else {
                        if (!rankingsMap.get(username).containsKey(contest)) {
                            rankingsMap.get(username).put(contest, points);
                        } else {
                            int currentPoints = rankingsMap.get(username).get(contest);
                            rankingsMap.get(username).put(contest, Math.max(points, currentPoints));
                        }
                    }
                }
            }

            input2 = scanner.nextLine();
        }

        int totalScore = 0;
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : rankingsMap.entrySet()) {
            int currentScore = entry.getValue().values().stream().mapToInt(i -> i).sum();
            if (currentScore > totalScore) {
                totalScore = currentScore;
            }
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : rankingsMap.entrySet()) {
            if (entry.getValue().values().stream().mapToInt(i -> i).sum() == totalScore) {
                System.out.printf("Best candidate is %s with total %d points.%n", entry.getKey(), totalScore);
            }
        }

        System.out.println("Ranking:");
        rankingsMap.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet().stream().
                    sorted((f, s) -> s.getValue() - f.getValue()).
                    forEach(i -> System.out.printf("#  %s -> %d%n", i.getKey(), i.getValue()));
        });

    }
}

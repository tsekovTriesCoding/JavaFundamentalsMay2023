package A16AssociativeArraysAndLambdaAndStreamAPI.MoreExercise;

import java.lang.ref.SoftReference;
import java.util.*;
import java.util.stream.Collectors;

public class P02Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, TreeMap<String, Integer>> contestsMap = new LinkedHashMap<>();
        Map<String, Integer> individualStandingsMap = new TreeMap<>();
        while (!input.equals("no more time")) {
            String[] tokens = input.split(" -> ");
            String username = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);

            if (!contestsMap.containsKey(contest)) {
                TreeMap<String, Integer> currentPointsMap = new TreeMap<>();
                currentPointsMap.put(username, points);
                contestsMap.put(contest, currentPointsMap);

            } else {
                if (contestsMap.get(contest).containsKey(username)) {
                    int currentPoints = contestsMap.get(contest).get(username);
                    contestsMap.get(contest).put(username, Math.max(currentPoints, points));

                } else {
                    contestsMap.get(contest).put(username, points);
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, TreeMap<String, Integer>> entry : contestsMap.entrySet()) {
            for (Map.Entry<String, Integer> contestMap : entry.getValue().entrySet()) {
                individualStandingsMap.putIfAbsent(contestMap.getKey(), 0);
                individualStandingsMap.put(contestMap.getKey(), individualStandingsMap.get(contestMap.getKey()) + contestMap.getValue());
            }
        }

        for (Map.Entry<String, TreeMap<String, Integer>> entry : contestsMap.entrySet()) {
            int counter = 1;
            System.out.printf("%s: %d participants%n", entry.getKey(), entry.getValue().size());
            for (Map.Entry<String, Integer> e : entry.getValue().entrySet().stream().sorted(Map.Entry.comparingByValue
                    (Comparator.reverseOrder())).collect(Collectors.toList())) {
                System.out.printf("%d. %s <::> %d%n", counter, e.getKey(), e.getValue());
                counter++;
            }
        }

        System.out.println("Individual standings:");
        int position = 1;
        for (Map.Entry<String, Integer> entry : individualStandingsMap.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                collect(Collectors.toList())){
            System.out.printf("%d. %s -> %d%n", position, entry.getKey(), entry.getValue());
            position++;
        }

    }
}

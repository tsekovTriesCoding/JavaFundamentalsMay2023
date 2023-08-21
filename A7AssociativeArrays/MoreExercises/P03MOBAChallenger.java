package A16AssociativeArraysAndLambdaAndStreamAPI.MoreExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P03MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, TreeMap<String, Integer>> playersPoolMap = new TreeMap<>();

        while (!command.equals("Season end")) {
            String[] tokens = command.split(" -> | vs ");

            if (command.contains("->")) {
                String player = tokens[0];
                String position = tokens[1];
                int skill = Integer.parseInt(tokens[2]);

                if (!playersPoolMap.containsKey(player)) {
                    TreeMap<String, Integer> newSkillMap = new TreeMap<>();
                    newSkillMap.put(position, skill);
                    playersPoolMap.put(player, newSkillMap);
                } else {
                    TreeMap<String, Integer> currentSkillMap = playersPoolMap.get(player);
                    if (currentSkillMap.containsKey(position)) {
                        int currentSkill = currentSkillMap.get(position);

                        if (currentSkill < skill) {
                            currentSkillMap.put(position, skill);
                        }
                    } else {
                        currentSkillMap.put(position, skill);
                        playersPoolMap.put(player, currentSkillMap);
                    }
                }
            } else {
                String player1 = tokens[0];
                String player2 = tokens[1];

                if (playersPoolMap.containsKey(player1) && playersPoolMap.containsKey(player2)) {
                    Map<String, Integer> player1SkillMap = playersPoolMap.get(player1);
                    Map<String, Integer> player2SkillMap = playersPoolMap.get(player2);

                    boolean haveCommonPosition = false;

                    for (String posPlayer1 : player1SkillMap.keySet()) {
                        for (String posPlayer2 : player2SkillMap.keySet()) {
                            if (posPlayer1.equals(posPlayer2)) {
                                haveCommonPosition = true;
                                break;
                            }
                        }
                    }

                    if (haveCommonPosition) {
                        if (player1SkillMap.values().stream().mapToInt(i -> i).sum() >
                                player2SkillMap.values().stream().mapToInt(i -> i).sum()) {
                            playersPoolMap.remove(player2);
                        } else if (player2SkillMap.values().stream().mapToInt(i -> i).sum() >
                                player1SkillMap.values().stream().mapToInt(i -> i).sum()) {
                            playersPoolMap.remove(player1);
                        }
                    }

                }
            }

            command = scanner.nextLine();
        }

        playersPoolMap.entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int result = Integer.compare(p2.getValue().values().stream().mapToInt(i -> i).sum(),
                            p1.getValue()
                                    .values().
                                    stream().mapToInt(i -> i).sum());
                    if (result == 0) {
                        result = p1.getKey().compareTo(p2.getKey());
                    }
                    return result;
                })
                .forEach(entry -> {
                    System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue()
                            .values()
                            .stream()
                            .mapToInt(i -> i).sum());
                    entry.getValue()
                            .entrySet()
                            .stream()
                            .sorted((e1, e2) -> {
                                int result = Integer.compare(e2.getValue(), e1.getValue());
                                if (result == 0) {
                                    result = e1.getKey().compareTo(e2.getKey());
                                }
                                return result;
                            }).forEach(e -> {
                                System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue());
                            });
                });
    }
}

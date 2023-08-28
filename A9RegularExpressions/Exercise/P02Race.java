package A20ExerciseRegularExpressions.Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> participantsList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        Map<String, Integer> participantsDistancesMap = new HashMap<>();

        participantsList.forEach(participant -> participantsDistancesMap.put(participant, 0));

        String letterRegex = "[A-Za-z]";
        Pattern letterPattern = Pattern.compile(letterRegex);

        String digitRegex = "[0-9]";
        Pattern digitPattern = Pattern.compile(digitRegex);


        while (!input.equals("end of race")) {
            Matcher letterMatcher = letterPattern.matcher(input);
            StringBuilder nameBuilder = new StringBuilder();

            while (letterMatcher.find()) {
                nameBuilder.append(letterMatcher.group());
            }

            Matcher digitMatcher = digitPattern.matcher(input);
            int distance = 0;
            while (digitMatcher.find()) {
                distance += Integer.parseInt(digitMatcher.group());
            }

            String participantName = nameBuilder.toString();

            if (participantsList.contains(participantName)) {
                int currentDistance = participantsDistancesMap.get(participantName);

                participantsDistancesMap.put(participantName, currentDistance + distance);
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i <= 2; i++) {

            if (i == 0) {
                System.out.println("1st place: " + participantsList.get(i));
            } else if (i == 1) {
                System.out.println("2nd place: " + participantsList.get(i));
            } else if (i == 2) {
                System.out.println("3rd place: " + participantsList.get(i));
            }
        }

    }
}

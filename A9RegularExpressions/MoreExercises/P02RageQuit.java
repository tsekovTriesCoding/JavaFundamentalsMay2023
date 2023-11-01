package A9RegularExpressions.MoreExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String stringRegex = "[^\\d]+[\\d]+";
        Pattern stringPattern = Pattern.compile(stringRegex);
        Matcher stringMatcher = stringPattern.matcher(input);

        StringBuilder rageMessageSb = new StringBuilder();
        while (stringMatcher.find()) {
            String currentString = stringMatcher.group().toUpperCase();

            String countRegex = "\\d+";
            Pattern countPattern = Pattern.compile(countRegex);
            Matcher countMatcher = countPattern.matcher(currentString);
            String message = currentString.split("\\d+")[0];

            int count = 0;
            if (countMatcher.find()) {
                count = Integer.parseInt(countMatcher.group());
            }

            for (int i = 1; i <= count; i++) {
                rageMessageSb.append(message);
            }

        }

        String output = rageMessageSb.toString();

        List<Character> uniqueSymbolsList = getUniqueSymbolsList(output);
        int uniqueSymbolsCount = uniqueSymbolsList.size();
        System.out.printf("Unique symbols used: %d%n", uniqueSymbolsCount);
        System.out.println(output);
    }

    public static List<Character> getUniqueSymbolsList(String output) {
        List<Character> uniqueSymbolsList = new ArrayList<>();

        for (int i = 0; i <= output.length() - 1; i++) {

            if (!uniqueSymbolsList.contains(output.charAt(i))) {
                uniqueSymbolsList.add(output.charAt(i));
            }
        }
        return uniqueSymbolsList;
    }
}

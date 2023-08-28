package A20ExerciseRegularExpressions.MoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputPartsArr = scanner.nextLine().split("\\|");

        String capitalLettersRegex = "([#$%*&])(?<capitalLetters>[A-Z]+)\\1";
        Pattern capLettersPattern = Pattern.compile(capitalLettersRegex);
        Matcher capLettersMatcher = capLettersPattern.matcher(inputPartsArr[0]);

        String asciiCodeLengthRegex = "(6[5-9]|[7-8][0-9]|90):([0-9]|1[0-9]){2}";
        Pattern asciiCodeLengthPattern = Pattern.compile(asciiCodeLengthRegex);
        Matcher asciiCodeLengthMatcher = asciiCodeLengthPattern.matcher(inputPartsArr[1]);

        List<String> asciiCodesAndLengthsList = new ArrayList<>();
        while (asciiCodeLengthMatcher.find()) {
            asciiCodesAndLengthsList.add(asciiCodeLengthMatcher.group());
        }

        StringBuilder lettersFound = new StringBuilder();
        while (capLettersMatcher.find()) {
            lettersFound.append(capLettersMatcher.group("capitalLetters"));
        }

        for (char letter : lettersFound.toString().toCharArray()) {

            for (String s : asciiCodesAndLengthsList) {
                int value = Integer.parseInt(s.split(":")[0]);
                char symbol = (char) value;
                boolean match = false;

                if (letter == symbol) {
                    int length = 1 + Integer.parseInt(s.split(":")[1]);
                    String[] thirdPartArr = inputPartsArr[2].split("\\s+");

                    for (String words : thirdPartArr) {

                        if (words.startsWith(String.valueOf(letter)) && words.length() == length) {
                            System.out.println(words);
                            match = true;
                            break;
                        }
                    }
                }
                if (match) {
                    break;
                }
            }

        }
    }
}

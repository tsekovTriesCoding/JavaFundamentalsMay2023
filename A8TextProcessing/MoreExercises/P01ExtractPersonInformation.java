package A18ExerciseTextProcessing.MoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();

            String nameRegex = "@(?<name>[A-Za-z]+)\\|";
            Pattern namePattern = Pattern.compile(nameRegex);
            Matcher nameMatcher = namePattern.matcher(input);

            String name = "";
            if (nameMatcher.find()) {
                name = nameMatcher.group("name");
            }

            String ageRegex = "#(?<age>\\d+)\\*";
            Pattern agePattern = Pattern.compile(ageRegex);
            Matcher ageMatcher = agePattern.matcher(input);

            String age = "";
            if (ageMatcher.find()) {
                age = ageMatcher.group("age");


            }

            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}

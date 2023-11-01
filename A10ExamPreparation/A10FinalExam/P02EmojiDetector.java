package A10ExamPreparation.A10FinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String digitRegex = "\\d";
        Pattern digitPattern = Pattern.compile(digitRegex);
        Matcher digitMatcher = digitPattern.matcher(input);

        long coolThreshold = 1;
        while (digitMatcher.find()) {
            coolThreshold *= Integer.parseInt(digitMatcher.group());
        }

        System.out.println("Cool threshold: " + coolThreshold);

        String regex = "(::|\\*\\*)(?<emoji>[A-Z][a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> coolEmojis = new ArrayList<>();
        int validEmojisCount = 0;
        while (matcher.find()) {
            validEmojisCount++;
            String currentEmoji = matcher.group("emoji");

            long currentCoolness = 0;
            for (char symbol : currentEmoji.toCharArray()) {
                currentCoolness += symbol;
            }

            if (currentCoolness > coolThreshold) {
                coolEmojis.add(matcher.group());
            }
        }

        System.out.println(validEmojisCount + " emojis found in the text. The cool ones are:");

        for (String emoji : coolEmojis) {
            System.out.println(emoji);
        }
    }
}

package ExamPreparation.A6FinalExamRetake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "(@|#)(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int validWordsCount = 0;
        List<String> mirrorWordsList = new ArrayList<>();
        while (matcher.find()) {
            validWordsCount++;

            String firstWord = matcher.group("wordOne");
            String secondWord = matcher.group("wordTwo");

            StringBuilder sb = new StringBuilder(secondWord);

            if (firstWord.equals(sb.reverse().toString())) {
                String output = String.format("%s <=> %s", firstWord, secondWord);
                mirrorWordsList.add(output);
            }

        }

        printValidPairsCount(validWordsCount);
        printMirrorWords(mirrorWordsList);

    }

    private static void printMirrorWords(List<String> mirrorWordsList) {
        if (mirrorWordsList.size() > 0) {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", mirrorWordsList));
        } else {
            System.out.println("No mirror words!");
        }
    }

    private static void printValidPairsCount(int validWordsCount) {
        if (validWordsCount > 0) {
            System.out.println(validWordsCount + " word pairs found!");
        } else {
            System.out.println("No word pairs found!");
        }
    }
}

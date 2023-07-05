package A2ExerciseBasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.Scanner;

public class P02EnglishNameOfTheLastDigit {

    public static int lastDigit(int a) {
        int lastDigit = a % 10;
        return lastDigit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        String[] singleDigit = new String[]{"zero", "one", "two", "three",
                "four", "five", "six", "seven", "eight", "nine", "ten"};

        int result = lastDigit(num);
        System.out.println(singleDigit[result]);
    }
}

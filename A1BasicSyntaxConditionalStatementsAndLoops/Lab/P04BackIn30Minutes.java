package A1BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class P04BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hourIn = Integer.parseInt(scanner.nextLine());
        int minutesIn = Integer.parseInt(scanner.nextLine());

        int totalMinutes = minutesIn + hourIn * 60 + 30;
        int hour = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        if (hour > 23) {
            hour = 0;
        }

        String output = String.format("%d:%02d", hour, minutes);

        System.out.println(output);
    }
}

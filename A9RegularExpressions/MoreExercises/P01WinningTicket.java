package A9RegularExpressions.MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] ticketsArr = scanner.nextLine().split("\\s*,+\\s*");

        String regex = ".*?(?=(?<symbol>[@#$^]))(?<match>\\k<symbol>{6,}).*(?<=.{10})\\k<match>.*";
        Pattern pattern = Pattern.compile(regex);

        for (String ticket : ticketsArr) {
            Matcher matcher = pattern.matcher(ticket);
            if (ticket.length() == 20) {
                StringBuilder matchSb = new StringBuilder();

                if (matcher.find()) {
                    matchSb.append(matcher.group("match"));
                    String match = matchSb.toString();
                    int symbolCounter = match.length();

                    String winningSymbol = matcher.group("symbol");
                    if (symbolCounter < 10) {
                        System.out.printf("ticket \"%s\" - %d%s%n", ticket, symbolCounter, winningSymbol);
                    } else if (symbolCounter == 10) {
                        System.out.printf("ticket \"%s\" - %d%s Jackpot!%n", ticket, symbolCounter, winningSymbol);
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                }

            } else {
                System.out.println("invalid ticket");
            }
        }
    }
}

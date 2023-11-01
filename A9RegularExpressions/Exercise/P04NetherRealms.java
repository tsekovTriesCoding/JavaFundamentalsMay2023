package A9RegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] demonsArr = input.split("\\s*,\\s*");

        String healthRegex = "[^0-9+\\-\\/*.]";
        Pattern healthPattern = Pattern.compile(healthRegex);

        String damageRegex = "\\+?\\-?[0-9]+\\.?[0-9]*";
        Pattern dmgPattern = Pattern.compile(damageRegex);

        String operatorRegex = "[\\*\\/]";
        Pattern operatorPattern = Pattern.compile(operatorRegex);

        for (String demon : demonsArr) {
            Matcher healthMatcher = healthPattern.matcher(demon);

            int health = 0;
            while (healthMatcher.find()) {
                String currentSymbol = healthMatcher.group();
                int asciiValueOfChar = currentSymbol.charAt(0);
                health += asciiValueOfChar;
            }

            Matcher dmgMatcher = dmgPattern.matcher(demon);

            double damage = 0;
            while (dmgMatcher.find()) {
                double currentNum = Double.parseDouble(dmgMatcher.group());
                damage += currentNum;
            }

            Matcher operatorMatcher = operatorPattern.matcher(demon);

            while (operatorMatcher.find()) {
                String currentOperator = operatorMatcher.group();

                switch (currentOperator) {
                    case "/":
                        damage /= 2;
                        break;
                    case "*":
                        damage *= 2;
                        break;
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n", demon, health, damage);

        }


    }
}

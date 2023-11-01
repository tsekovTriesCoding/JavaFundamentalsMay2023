package A8TextProcessing.MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] keyArr = scanner.nextLine().split("\\s+");
        String input = scanner.nextLine();

        while (!input.equals("find")) {

            StringBuilder sb = new StringBuilder();
            boolean over = false;
            for (int indexOfKey = 0; indexOfKey <= keyArr.length - 1; indexOfKey++) {
                for (int indexOfString = 0; indexOfString <= input.length() - 1; indexOfString++) {
                    int keyNum = Integer.parseInt(keyArr[indexOfKey]);
                    char newSymbol = (char) (input.charAt(indexOfString) - keyNum);
                    sb.append(newSymbol);
                    indexOfKey++;
                    if (indexOfKey == keyArr.length) {
                        indexOfKey = 0;
                    }
                    if (indexOfString == input.length() - 1) {
                        over = true;
                    }
                }
                if (over) {
                    break;
                }
            }
            String treasureType = "";
            String treasureTypeRegex = "&(?<type>[A-Za-z]+)&";
            Pattern typePattern = Pattern.compile(treasureTypeRegex);
            Matcher typeMatcher = typePattern.matcher(sb);

            if (typeMatcher.find()) {
                treasureType = typeMatcher.group("type");
            }

            String coordinates = "";
            String coordinatesRegex = "<(?<coordinates>[A-Za-z\\d+]+)>";
            Pattern coordinatesPattern = Pattern.compile(coordinatesRegex);
            Matcher coordinatesMatcher = coordinatesPattern.matcher(sb);

            if (coordinatesMatcher.find()) {
                coordinates = coordinatesMatcher.group("coordinates");
            }


            System.out.printf("Found %s at %s%n", treasureType, coordinates);
            input = scanner.nextLine();
        }
    }
}

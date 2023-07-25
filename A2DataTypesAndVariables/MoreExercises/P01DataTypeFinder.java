package A4ExerciseDataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class P01DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        while (!input.equals("END")) {
            String dataType = "string";

            try {
                int num = Integer.parseInt(input);
                dataType = "integer";
            } catch (Exception e) {
                try {
                    double floatNum = Double.parseDouble(input);
                    dataType = "floating point";
                } catch (Exception r) {
                    if (input.length() == 1 && !dataType.equals("integer")) {
                        dataType = "character";
                    }
                }
            }

            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                dataType = "boolean";
            }
            System.out.printf("%s is %s type%n", input, dataType);
            input = scanner.nextLine();
        }

    }

}



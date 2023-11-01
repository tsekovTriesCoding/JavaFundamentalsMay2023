package A10ExamPreparation.A1FinalExam;

import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Travel")) {

            if (input.contains("Add")) {
                stops = add(stops, input);
            } else if (input.contains("Remove")) {
                stops = remove(stops, input);
            } else if (input.contains("Switch")) {
                stops = switchStops(stops, input);
            }

            input = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s", stops);
    }

    private static String switchStops(String stops, String input) {
        String oldString = input.split(":")[1];
        String newString = input.split(":")[2];

        if (stops.contains(oldString)) {
            stops = stops.replace(oldString, newString);
        }

        System.out.println(stops);
        return stops;
    }

    private static String remove(String stops, String input) {
        int startIndex = Integer.parseInt(input.split(":")[1]);
        int endIndex = Integer.parseInt(input.split(":")[2]);

        if (startIndex >= 0 && startIndex < stops.length() && endIndex >= 0 && endIndex < stops.length()) {
            StringBuilder sb = new StringBuilder(stops);
            sb.delete(startIndex, endIndex + 1);

            stops = sb.toString();
        }

        System.out.println(stops);
        return stops;
    }

    private static String add(String stops, String input) {
        int index = Integer.parseInt(input.split(":")[1]);
        String stop = input.split(":")[2];

        if (index >= 0 && index < stops.length()) {
            StringBuilder sb = new StringBuilder(stops);
            sb.insert(index, stop);

            stops = sb.toString();
        }

        System.out.println(stops);
        return stops;
    }
}

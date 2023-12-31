package A2DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P08BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double biggestVolume = Double.MIN_VALUE;
        String biggestKeg = "";

        for (int i = 1; i <= n; i++) {
            String kegModel = scanner.nextLine();
            double kegRadius = Double.parseDouble(scanner.nextLine());
            int kegHeight = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * Math.pow(kegRadius, 2) * kegHeight;

            if (volume >= biggestVolume) {
                biggestVolume = volume;
                biggestKeg = kegModel;
            }
        }
        System.out.println(biggestKeg);
    }
}

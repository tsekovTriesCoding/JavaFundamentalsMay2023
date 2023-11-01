package ExamPreparation.A07MidExam;

import java.util.Scanner;

public class P01GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double foodQuantityInGrams = Double.parseDouble(scanner.nextLine()) * 1000;
        double hayQuantityInGrams = Double.parseDouble(scanner.nextLine()) * 1000;
        double quantityCoverInGrams = Double.parseDouble(scanner.nextLine()) * 1000;
        double guineaPigWeightInGrams = Double.parseDouble(scanner.nextLine()) * 1000;

        int day = 0;
        while (foodQuantityInGrams > 0 && hayQuantityInGrams > 0 && quantityCoverInGrams > 0 && day < 30) {
            day++;

            foodQuantityInGrams -= 300;

            if (day % 2 == 0) {
                hayQuantityInGrams -= foodQuantityInGrams * 0.05;
            }

            if (day % 3 == 0) {
                quantityCoverInGrams -= guineaPigWeightInGrams / 3;
            }

        }

        boolean everythingIsEnough = foodQuantityInGrams > 0 && hayQuantityInGrams > 0 && quantityCoverInGrams > 0;

        if (everythingIsEnough) {
            System.out.printf("Everything is fine! Puppy is happy!" +
                            " Food: %.2f, Hay: %.2f, Cover: %.2f.",
                    foodQuantityInGrams / 1000, hayQuantityInGrams / 1000, quantityCoverInGrams / 1000);
        } else {
            System.out.println("Merry must go to the pet store!");
        }

    }
}

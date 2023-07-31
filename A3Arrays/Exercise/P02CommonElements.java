package A6ExerciseArrays.Exercise;

import java.util.Scanner;

public class P02CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array1 = scanner.nextLine().split(" ");
        String[] array2 = scanner.nextLine().split(" ");

        for (String secondElement : array2) {
            for (String firstElement : array1) {

                if (secondElement.equals(firstElement)) {
                    System.out.print(firstElement + " ");
                }
            }
        }
    }
}

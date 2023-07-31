package A6ExerciseArrays.Exercise;

import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] people = new int[n];
        int sumOfPeople = 0;
        for (int i = 0; i < n; i++) {
            int currentPeople = Integer.parseInt(scanner.nextLine());

            people[i] = currentPeople;
            sumOfPeople += currentPeople;

        }
        for (int peopleNum : people) {
            System.out.print(peopleNum + " ");
        }

        System.out.println();
        System.out.println(sumOfPeople);
    }
}

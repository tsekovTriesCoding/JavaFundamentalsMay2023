package ExamPreparation.A4MidExamRetake;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        boolean allElementsHit = false;

        int numberOfMoves = 0;
        while (!command.equals("end")) {

            int index1 = Integer.parseInt(command.split(" ")[0]);
            int index2 = Integer.parseInt(command.split(" ")[1]);

            numberOfMoves++;

            if (getEqualIndexes(index1, index2) || getIndexOutOfBound(elements, index1, index2)) {
                String elementToAdd = "-" + numberOfMoves + "a";

                elements.add(elements.size() / 2, elementToAdd);
                elements.add(elements.size() / 2, elementToAdd);

                System.out.println("Invalid input! Adding additional elements to the board");
            } else {

                String element1 = elements.get(index1);
                String element2 = elements.get(index2);
                if (Objects.equals(element1, element2)) {
                    elements.remove(element1);
                    elements.remove(element2);

                    System.out.printf("Congrats! You have found matching elements - %s!%n", element1);
                } else {
                    System.out.println("Try again!");
                }
            }

            if (elements.size() == 0) {
                allElementsHit = true;
                break;
            }

            command = scanner.nextLine();
        }

        if (allElementsHit) {
            System.out.printf("You have won in %d turns!", numberOfMoves);
        } else {
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ", elements));
        }


    }

    public static boolean getEqualIndexes(int index1, int index2) {

        return index1 == index2;
    }

    public static boolean getIndexOutOfBound(List<String> elements, int index1, int index2) {

        boolean outOfBounds = false;
        if (index1 < 0 || index1 > elements.size() - 1) {
            outOfBounds = true;
        } else if (index2 < 0 || index2 > elements.size() - 1) {
            outOfBounds = true;
        }
        return outOfBounds;
    }
}

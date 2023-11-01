package A10ExamPreparation.A3MidExam;

import java.util.*;

public class P03Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> top5Numbers = new ArrayList<>();

        int sum = 0;
        for (int element : numbers) {
            sum += element;
        }
        double avgNumber = sum * 1.0 / numbers.length;

        for (int element : numbers) {
            if (element > avgNumber) {
                top5Numbers.add(element);
            }
        }

        Collections.sort(top5Numbers);
        Collections.reverse(top5Numbers);

        if (top5Numbers.size() == 0) {
            System.out.println("No");
        } else {
            int counter = 0;
            for (int number : top5Numbers) {
                System.out.print(number + " ");
                counter++;
                if (counter == 5) {
                    break;
                }
            }
        }
    }
}

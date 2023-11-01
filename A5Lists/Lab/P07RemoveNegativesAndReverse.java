package A5Lists.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class P07RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> positiveNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number >= 0) {
                positiveNumbers.add(number);
            }
        }

        Collections.reverse(positiveNumbers);

        if (positiveNumbers.size() > 0) {
            System.out.println(positiveNumbers.toString().replaceAll("[\\[\\],]", ""));

        } else {
            System.out.println("empty");
        }
    }
}

package A5Lists.MoreExercises;

import java.util.*;
import java.util.stream.Collectors;

public class P04MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers1 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> numbers2 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> newListOfNumbers = new ArrayList<>();

        while (numbers1.size() > 0 && numbers2.size() > 0) {
            newListOfNumbers.add(numbers1.get(0));
            numbers1.remove(0);
            newListOfNumbers.add(numbers2.get(numbers2.size() - 1));
            numbers2.remove(numbers2.get(numbers2.size() - 1));
        }

        List<Integer> numbersAfterMixingRules = new ArrayList<>();
        if (numbers2.size() > numbers1.size()) {
            Collections.sort(numbers2);
            getListAfterMixing(numbers2, newListOfNumbers, numbersAfterMixingRules);

        } else {
            Collections.sort(numbers1);
            getListAfterMixing(numbers1, newListOfNumbers, numbersAfterMixingRules);
        }

        Collections.sort(numbersAfterMixingRules);

        System.out.println(numbersAfterMixingRules.toString()
                .replaceAll("[\\[\\],]", ""));

    }

    private static void getListAfterMixing(List<Integer> numbers, List<Integer> newListOfNumbers, List<Integer> numbersAfterMixingRules) {
        int num1 = numbers.get(0);
        int num2 = numbers.get(1);

        for (int number : newListOfNumbers) {
            if (number > num1 && number < num2) {
                numbersAfterMixingRules.add(number);
            }
        }
    }
}

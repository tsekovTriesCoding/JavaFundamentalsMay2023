package A11ExerciseList.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> numbers2 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int specialBombNumber = numbers2.get(0);
        int numberPower = numbers2.get(1);

        while (numbers.contains(specialBombNumber)) {
            int index = numbers.indexOf(specialBombNumber);

            int left = Math.max(0, index - numberPower);
            int right = Math.min(index + numberPower, numbers.size() - 1);

            for (int i = right; i >= left; i--) {
                numbers.remove(i);

            }
        }

        int sum = 0;
        for (int number:numbers) {

            sum += number;
        }

        System.out.println(sum);
    }
}

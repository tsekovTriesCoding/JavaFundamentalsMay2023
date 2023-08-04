package A11ExerciseList.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> distances = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sumOfRemovedItems = 0;
        while (distances.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());

            if (index < 0) {
                index = 0;

                int removedItem = distances.get(index);
                int lastItem = distances.get(distances.size() - 1);
                distances.remove(index);
                distances.add(0, lastItem);

                sumOfRemovedItems = getSumOfRemovedItems(distances, sumOfRemovedItems, removedItem);

            } else if (index > distances.size() - 1) {
                index = distances.size() - 1;

                int removedItem = distances.get(index);
                int firstItem = distances.get(0);
                distances.remove(index);
                distances.add(firstItem);

                sumOfRemovedItems = getSumOfRemovedItems(distances, sumOfRemovedItems, removedItem);
            } else {
                int removedItem = distances.get(index);
                distances.remove(index);

                sumOfRemovedItems = getSumOfRemovedItems(distances, sumOfRemovedItems, removedItem);
            }
        }

        System.out.println(sumOfRemovedItems);
    }

    private static int getSumOfRemovedItems(List<Integer> distances, int sumOfRemovedItems, int removedItem) {
        for (int i = 0; i <= distances.size() - 1; i++) {
            int oldElement = distances.get(i);

            distances.remove(i);
            if (oldElement <= removedItem) {
                distances.add(i, oldElement + removedItem);
            } else {
                distances.add(i, oldElement - removedItem);
            }
        }

        sumOfRemovedItems += removedItem;
        return sumOfRemovedItems;
    }


}

package A5Lists.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList1 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> numbersList2 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();
        int minSize = Math.min(numbersList1.size(),numbersList2.size());

        for (int i = 0; i < minSize; i++) {
            int firstItem = numbersList1.get(i);
            int secondItem = numbersList2.get(i);

            resultList.add(firstItem);
            resultList.add(secondItem);
        }

        if (numbersList1.size() > numbersList2.size()) {
            resultList.addAll(numbersList1.subList(minSize, numbersList1.size()));
        } else {
            resultList.addAll(numbersList2.subList(minSize, numbersList2.size()));
        }

        System.out.println(resultList.toString().replaceAll("[\\[\\],]", ""));
    }
}

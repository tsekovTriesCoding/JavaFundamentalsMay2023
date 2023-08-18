package A15AssociativeArrays;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] nums = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        TreeMap<Double, Integer> countsMap = new TreeMap<>();

        for (double num : nums) {
            if (!countsMap.containsKey(num)) {
                countsMap.put(num, 0);
            }

            countsMap.put(num, countsMap.get(num) + 1);
        }

        for (Map.Entry<Double, Integer> entry : countsMap.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.######");

            System.out.printf("%s -> %d\n", df.format(entry.getKey()), entry.getValue());
        }

    }
}

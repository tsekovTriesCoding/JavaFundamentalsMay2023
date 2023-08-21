package A16AssociativeArraysAndLambdaAndStreamAPI.Exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<Character, Integer> charMap = new LinkedHashMap<>();

        for (char symbol : input.toCharArray()) {
            if (symbol == ' ') {
                continue;
            }

            if (charMap.containsKey(symbol)) {
                int currentCount = charMap.get(symbol);
                charMap.put(symbol, currentCount + 1);
            } else {
                charMap.put(symbol, 1);
            }
        }

        charMap.forEach((key, value) -> System.out.println(key + " -> " + value));

    }
}

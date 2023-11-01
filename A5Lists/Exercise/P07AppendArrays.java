package A5Lists.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        Collections.reverse(numbers);

        System.out.println(numbers.toString()
                .replaceAll("[\\[\\],]", "")
                .trim()
                .replaceAll("\\s+", " "));
    }
}

package A5Lists.MoreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        List<String> input = Arrays.stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());


        String output = "";
        for (String element : numbers) {
            int sumOfDigits = 0;

            for (char i = 0; i <= element.length() - 1; i++) {
                char num = element.charAt(i);
                sumOfDigits += num - 48;
                ;
            }

            if (sumOfDigits > input.size()) {
                sumOfDigits -= input.size();
            }
            for (int i = 0; i <= input.size() - 1; i++) {
                if (i == sumOfDigits) {
                    output += input.get(i);
                    input.remove(i);
                    break;
                }
            }
        }
        System.out.println(output);
    }
}

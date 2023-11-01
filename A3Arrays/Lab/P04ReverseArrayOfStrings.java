package A3Arrays.Lab;

import java.util.Scanner;

public class P04ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringArray = scanner.nextLine().split(" ");

        for (int i = 0; i < stringArray.length / 2; i++) {
            String replacedElement = stringArray[i];
            stringArray[i] = stringArray[stringArray.length - 1 - i];

            stringArray[stringArray.length - 1 - i] = replacedElement;

        }
        System.out.println(String.join(" ", stringArray));

    }
}

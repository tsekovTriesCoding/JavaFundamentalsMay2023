package A17TextProcessing;

import java.util.Scanner;

public class P03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputToRemove = scanner.nextLine();
        String input = scanner.nextLine();

        //int index = input.indexOf(inputToRemove);
        while (input.contains(inputToRemove)) { // може while цикълът да се върти докато индексът е различен о т -1

            input = input.replace(inputToRemove, "");

            //index = input.indexOf(inputToRemove);
        }
        System.out.println(input);
    }
}

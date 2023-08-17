package A13ObjectsAndClasses;

import java.util.Random;
import java.util.Scanner;

public class P01RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        Random rnd = new Random();

        for (int i = 0; i <= words.length - 1; i++) {

            int index1 = rnd.nextInt(words.length);
            int index2 = rnd.nextInt(words.length);

            String oldWord = words[index1];
            words[index1] = words[index2];
            words[index2] = oldWord;
        }

        System.out.println(String.join(System.lineSeparator(), words));
    }
}

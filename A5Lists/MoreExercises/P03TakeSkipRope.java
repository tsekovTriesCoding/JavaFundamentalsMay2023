package A5Lists.MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        List<Integer> numbersFromMessage = new ArrayList<>();
        List<Character> nonNumberFromMessage = new ArrayList<>();

        for (int i = 0; i <= message.length() - 1; i++) {

            if (Character.isDigit(message.charAt(i))) {
                numbersFromMessage.add(message.charAt(i) - 48);
            } else {
                nonNumberFromMessage.add(message.charAt(i));
            }
        }

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i <= numbersFromMessage.size() - 1; i++) {
            if (i % 2 == 0) {
                takeList.add(numbersFromMessage.get(i));
            } else {
                skipList.add(numbersFromMessage.get(i));
            }
        }

        String decryptedMessage = "";
        String skippedItems = "";

        int takeCount = 0;
        int skipCount = 0;
        for (int j = 0; j <= takeList.size() - 1; j++) {
            takeCount = takeList.get(j);
            skipCount = skipList.get(j);

            for (int k = 1; k <= takeCount; k++) {
                if (nonNumberFromMessage.size() == 0) {
                    break;
                }
                decryptedMessage += nonNumberFromMessage.get(0);
                nonNumberFromMessage.remove(0);
            }

            if (nonNumberFromMessage.size() == 0) {
                break;
            }
            for (int k = 1; k <= skipCount; k++) {
                skippedItems += nonNumberFromMessage.get(0);
                nonNumberFromMessage.remove(0);
            }
        }

        System.out.println(decryptedMessage);
    }
}

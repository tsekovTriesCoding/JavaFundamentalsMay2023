package A5Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> handOfCards1 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> handOfCards2 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (handOfCards1.size() > 0 && handOfCards2.size() > 0) {

            if (handOfCards1.get(0) > handOfCards2.get(0)) {
                int winningPlayerCard = handOfCards1.get(0);
                int losingPlayerCard = handOfCards2.get(0);

                handOfCards1.remove(Integer.valueOf(winningPlayerCard));
                handOfCards1.add(winningPlayerCard);
                handOfCards1.add(losingPlayerCard);
                handOfCards2.remove(Integer.valueOf(losingPlayerCard));

            } else if (handOfCards2.get(0) > handOfCards1.get(0)) {
                int winningPlayerCard = handOfCards2.get(0);
                int losingPlayerCard = handOfCards1.get(0);

                handOfCards2.remove(Integer.valueOf(winningPlayerCard));
                handOfCards2.add(winningPlayerCard);
                handOfCards2.add(losingPlayerCard);
                handOfCards1.remove(Integer.valueOf(losingPlayerCard));
            } else {
                int equalCard = handOfCards1.get(0);

                handOfCards1.remove(Integer.valueOf(equalCard));
                handOfCards2.remove(Integer.valueOf(equalCard));
            }

        }

        int sumOfCards = 0;
        if (handOfCards1.size() > 0) {
            for (int card : handOfCards1) {
                sumOfCards += card;
            }

            System.out.println("First player wins!" + " " + "Sum:" + " " + sumOfCards);
        } else {
            for (int card : handOfCards2) {
                sumOfCards += card;
            }

            System.out.println("Second player wins!" + " " + "Sum:" + " " + sumOfCards);
        }
    }
}

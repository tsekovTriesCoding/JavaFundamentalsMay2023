package A8TextProcessing.Exercise;

import java.util.Scanner;

public class P07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder sb = new StringBuilder(input);

        int totalStrength = 0;
        for (int index = 0; index <= sb.length() - 1; index++) {

            if (sb.charAt(index) == '>') {
                int strength = Integer.parseInt(String.valueOf(sb.charAt(index + 1)));
                totalStrength += strength;
            } else if (sb.charAt(index) != '>' && totalStrength > 0) {
                sb.deleteCharAt(index);
                totalStrength--;
                index--;
            }
        }
        System.out.println(sb);
    }
}

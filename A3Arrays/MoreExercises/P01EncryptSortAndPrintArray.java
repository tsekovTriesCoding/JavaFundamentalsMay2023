package A6ExerciseArrays.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P01EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] nameArray = new String[n];
        int[] encryptedNameArray = new int[n];

        for (int i = 0; i < n; i++) {
            String inputName = scanner.nextLine();
            nameArray[i] = inputName;
        }

        for (int i = 0; i <= nameArray.length - 1; i++) {
            String name = nameArray[i];
            int sumOfLetters = 0;
            for (int j = 0; j <= name.length() - 1; j++) {
                if (name.charAt(j) == 97 || name.charAt(j) == 65) {
                    sumOfLetters += name.charAt(j) * name.length();
                } else if (name.charAt(j) == 101 || name.charAt(j) == 69) {
                    sumOfLetters += name.charAt(j) * name.length();
                } else if (name.charAt(j) == 105 || name.charAt(j) == 73) {
                    sumOfLetters += name.charAt(j) * name.length();
                } else if (name.charAt(j) == 111 || name.charAt(j) == 79) {
                    sumOfLetters += name.charAt(j) * name.length();
                } else if (name.charAt(j) == 117 || name.charAt(j) == 85) {
                    sumOfLetters += name.charAt(j) * name.length();
                } else {
                    sumOfLetters += name.charAt(j) / name.length();
                }
            }
            encryptedNameArray[i] = sumOfLetters;
        }
        Arrays.sort(encryptedNameArray);
        for (int i = 0; i <= encryptedNameArray.length - 1; i++) {
            System.out.println(encryptedNameArray[i]);
        }
    }
}

package A3DataTypeAndVariables;

import java.util.Scanner;

public class P06CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char symbol1 = scanner.nextLine().charAt(0);
        char symbol2 = scanner.nextLine().charAt(0);
        char symbol3 = scanner.nextLine().charAt(0);

        String result = "" + (char) symbol1 + (char) symbol2 + (char) symbol3;

        System.out.print(result);
    }
}

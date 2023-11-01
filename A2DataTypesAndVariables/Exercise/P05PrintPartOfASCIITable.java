package A2DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P05PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int indexStart = Integer.parseInt(scanner.nextLine());
        int indexEnd = Integer.parseInt(scanner.nextLine());

        for (int i = indexStart; i <= indexEnd; i++) {
            System.out.print((char) i + " ");
        }
    }
}

package A10List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P06ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> productList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String product = scanner.nextLine();
            productList.add(product);
        }

        Collections.sort(productList);

        int placeInList = 1;

        for (String product : productList) {
            System.out.println(placeInList + "." + product);
            placeInList++;
        }
    }
}

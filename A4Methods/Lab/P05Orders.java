package A4Methods.Lab;

import java.util.Scanner;

public class P05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        printOrderPrice(product,quantity);

    }

    public static void printOrderPrice(String product, int quantity) {

        double price = 0;
        if (product.equals("coffee")) {
            price = 1.50;
        } else if (product.equals("water")) {
            price = 1;
        } else if (product.equals("coke")) {
            price = 1.40;
        } else if (product.equals("snacks")) {
            price = 2;
        }

        price = price * quantity;
        System.out.printf("%.2f", price);
    }
}

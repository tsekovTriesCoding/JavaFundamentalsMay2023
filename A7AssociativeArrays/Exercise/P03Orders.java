package A16AssociativeArraysAndLambdaAndStreamAPI.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        LinkedHashMap<String, Integer> productQuantityMap = new LinkedHashMap<>();
        LinkedHashMap<String, Double> productPriceMap = new LinkedHashMap<>();

        while (!command.equals("buy")) {
            String product = command.split("\\s+")[0];
            double price = Double.parseDouble(command.split("\\s+")[1]);
            int quantity = Integer.parseInt(command.split("\\s+")[2]);

            if (!productQuantityMap.containsKey(product)) {
                productQuantityMap.put(product, quantity);
            } else {
                int currentQuantity = productQuantityMap.get(product);

                productQuantityMap.put(product, currentQuantity + quantity);
            }

            productPriceMap.put(product, price);

            command = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : productQuantityMap.entrySet()) {

            String productName = entry.getKey();
            System.out.printf("%s -> %.2f\n", productName, entry.getValue() * productPriceMap.get(productName));
        }

    }
}

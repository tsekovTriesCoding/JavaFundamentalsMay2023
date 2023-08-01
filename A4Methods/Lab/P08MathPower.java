package A8Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P08MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        new DecimalFormat ("0.####").format(numPower(num1,power));
        System.out.println(new DecimalFormat("0.####").format(numPower(num1,power)));
    }
    public static double numPower (double num1,int num2) {

        return Math.pow(num1,num2);
    }
}

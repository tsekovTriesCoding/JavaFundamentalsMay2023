package A4Methods.MoreExercises;

import java.awt.*;
import java.util.Scanner;

public class P02CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        printClosestPoint(x1, y1, x2, y2);
    }

    public static void printClosestPoint(int x1, int y1, int x2, int y2) {

        int euclideanDistanceOfFirstPoint = (int) Math.pow(x1, 2) + (int) Math.pow(y1, 2);
        int euclideanDistanceOfSecondPoint = (int) Math.pow(x2, 2) + (int) Math.pow(y2, 2);

        if (euclideanDistanceOfFirstPoint < euclideanDistanceOfSecondPoint) {
            System.out.printf("(%d, %d)", x1, y1);
        } else if (euclideanDistanceOfSecondPoint < euclideanDistanceOfFirstPoint) {
            System.out.printf("(%d, %d)", x2, y2);
        } else {
            System.out.printf("(%d, %d)", x1, y1);
        }
    }
}

package A9ExerciseMethods.MoreExercises;

import java.util.Scanner;

public class P03LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        int x3 = Integer.parseInt(scanner.nextLine());
        int y3 = Integer.parseInt(scanner.nextLine());
        int x4 = Integer.parseInt(scanner.nextLine());
        int y4 = Integer.parseInt(scanner.nextLine());

        int distanceOfFirstLine = euclideanDistance(x1, y1, x2, y2);
        int distanceOfSecondLine = euclideanDistance(x3, y3, x4, y4);

        if (distanceOfFirstLine > distanceOfSecondLine) {
            if (euclideanDistanceOfTwoPoints(x1, y1) < euclideanDistanceOfTwoPoints(x2, y2)) {
                System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
            } else {
                System.out.printf("(%d, %d)(%d, %d)", x2, y2, x1, y1);
            }
        } else if (distanceOfSecondLine > distanceOfFirstLine) {
            if (euclideanDistanceOfTwoPoints(x3, y3) < euclideanDistanceOfTwoPoints(x4, y4)) {
                System.out.printf("(%d, %d)(%d, %d)", x3, y3, x4, y4);
            } else {
                System.out.printf("(%d, %d)(%d, %d)", x4, y4, x3, y3);
            }
        } else {
            if (euclideanDistanceOfTwoPoints(x1, y1) < euclideanDistanceOfTwoPoints(x2, y2)) {
                System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
            } else {
                System.out.printf("(%d, %d)(%d, %d)", x2, y2, x1, y1);
            }
        }

    }

    public static int euclideanDistance(int x1, int y1, int x2, int y2) {

        return (int) Math.pow(x1 - x2, 2) + (int) Math.pow(y1 - y2, 2);
    }

    public static int euclideanDistanceOfTwoPoints(int x, int y) {

        return (int) Math.pow(x, 2) + (int) Math.pow(y, 2);

    }
}

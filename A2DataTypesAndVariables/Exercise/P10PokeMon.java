package A2DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());

        int targetsHit = 0;
        int startPokePower = pokePower;

        while (pokePower >= distance) {
            pokePower -= distance;
            targetsHit++;

            if (pokePower == startPokePower / 2 && exhaustionFactor != 0) {
                pokePower /= exhaustionFactor;
            }
        }
        System.out.println(pokePower);
        System.out.println(targetsHit);
    }
}

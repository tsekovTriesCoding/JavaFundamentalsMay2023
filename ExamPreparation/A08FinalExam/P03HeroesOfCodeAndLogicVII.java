package ExamPreparation.A08FinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> heroesHp = new LinkedHashMap<>();
        Map<String, Integer> heroesMp = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            addHero(heroesHp, heroesMp, tokens);
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String heroName = tokens[1];

            switch (command) {
                case "CastSpell":
                    castSpell(heroesMp, tokens, heroName);
                    break;
                case "TakeDamage":
                    takeDamage(heroesHp, tokens);
                    break;
                case "Recharge":
                    recharge(heroesMp, tokens);
                    break;
                case "Heal":
                    heal(heroesHp, tokens);
                    break;
            }

            input = scanner.nextLine();
        }

        heroesHp.forEach((heroName, hp) -> {
            System.out.println(heroName);
            System.out.println("HP: " + hp);
            System.out.println("MP: " + heroesMp.get(heroName));
        });
    }

    private static void addHero(Map<String, Integer> heroesHp, Map<String, Integer> heroesMp, String[] tokens) {
        String heroName = tokens[0];
        int hitPoints = Integer.parseInt(tokens[1]);
        int manaPoints = Integer.parseInt(tokens[2]);

        if (hitPoints > 100) {
            hitPoints = 100;
        }

        if (manaPoints > 200) {
            manaPoints = 200;
        }

        heroesHp.putIfAbsent(heroName, hitPoints);
        heroesMp.putIfAbsent(heroName, manaPoints);
    }

    private static void heal(Map<String, Integer> heroesHp, String[] tokens) {
        int amount;
        String heroName;
        int amountRecovered;
        heroName = tokens[1];
        amount = Integer.parseInt(tokens[2]);

        amountRecovered = amount;

        if (heroesHp.get(heroName) + amount > 100) {
            amountRecovered = 100 - heroesHp.get(heroName);
            heroesHp.put(heroName, 100);
        } else {
            heroesHp.put(heroName, heroesHp.get(heroName) + amount);
        }

        System.out.printf("%s healed for %d HP!%n", heroName, amountRecovered);
    }

    private static void recharge(Map<String, Integer> heroesMp, String[] tokens) {
        String heroName;
        heroName = tokens[1];
        int amount = Integer.parseInt(tokens[2]);

        int amountRecovered = amount;

        if (heroesMp.get(heroName) + amount > 200) {
            amountRecovered = 200 - heroesMp.get(heroName);
            heroesMp.put(heroName, 200);
        } else {
            heroesMp.put(heroName, heroesMp.get(heroName) + amount);
        }

        System.out.printf("%s recharged for %d MP!%n", heroName, amountRecovered);
    }

    private static void takeDamage(Map<String, Integer> heroesHp, String[] tokens) {
        String heroName;
        heroName = tokens[1];
        int damage = Integer.parseInt(tokens[2]);
        String attacker = tokens[3];

        heroesHp.put(heroName, heroesHp.get(heroName) - damage);

        if (heroesHp.get(heroName) > 0) {
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage,
                    attacker, heroesHp.get(heroName));
        } else {
            System.out.printf("%s has been killed by %s!%n", heroName, attacker);
            heroesHp.remove(heroName);
            heroesHp.remove(heroName);
        }
    }

    private static void castSpell(Map<String, Integer> heroesMp, String[] tokens, String heroName) {
        int mpNeeded = Integer.parseInt(tokens[2]);
        String spellName = tokens[3];

        if (heroesMp.get(heroName) >= mpNeeded) {
            heroesMp.put(heroName, heroesMp.get(heroName) - mpNeeded);

            System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, heroesMp.get(heroName));
        } else {
            System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
        }
    }
}

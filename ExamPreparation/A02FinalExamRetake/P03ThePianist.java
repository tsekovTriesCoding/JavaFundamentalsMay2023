package ExamPreparation.A02FinalExamRetake;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> pieceWithComposer = new LinkedHashMap<>();
        Map<String, String> pieceWithKey = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\|");

            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];

            pieceWithComposer.putIfAbsent(piece, composer);
            pieceWithKey.putIfAbsent(piece, key);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String piece = input.split("\\|")[1];
            if (input.startsWith("Add")) {
                add(pieceWithComposer, pieceWithKey, input, piece);
            } else if (input.startsWith("Remove")) {
                remove(pieceWithComposer, pieceWithKey, piece);
            } else if (input.startsWith("ChangeKey")) {
                changeKey(pieceWithKey, input, piece);
            }

            input = scanner.nextLine();
        }

        printOutput(pieceWithComposer, pieceWithKey);

    }

    private static void printOutput(Map<String, String> pieceWithComposer, Map<String, String> pieceWithKey) {
        for (Map.Entry<String, String> piece : pieceWithComposer.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", piece.getKey(), piece.getValue(), pieceWithKey.get(piece.getKey()));
        }
    }

    private static void changeKey(Map<String, String> pieceWithKey, String input, String piece) {
        String newKey = input.split("\\|")[2];
        if (pieceWithKey.containsKey(piece)) {
            pieceWithKey.put(piece, newKey);

            System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
        }
    }

    private static void remove(Map<String, String> pieceWithComposer, Map<String, String> pieceWithKey, String piece) {
        if (pieceWithComposer.containsKey(piece)) {
            pieceWithComposer.remove(piece);
            pieceWithKey.remove(piece);

            System.out.printf("Successfully removed %s!%n", piece);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
        }
    }

    private static void add(Map<String, String> pieceWithComposer, Map<String, String> pieceWithKey, String input, String piece) {
        String composer = input.split("\\|")[2];
        String key = input.split("\\|")[3];

        if (!pieceWithComposer.containsKey(piece)) {
            pieceWithComposer.put(piece, composer);
            pieceWithKey.put(piece, key);

            System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
        } else {
            System.out.printf("%s is already in the collection!%n", piece);
        }
    }
}

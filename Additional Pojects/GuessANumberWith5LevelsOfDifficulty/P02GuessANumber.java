package A4ExerciseDataTypesAndVariables.Projects;

import java.util.Random;
import java.util.Scanner;

public class P02GuessANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random randomNumber = new Random();

        int computerNumber = randomNumber.nextInt(100);
        int level = 1;
        int inputCounter = 0;

        while (true) {

            if (inputCounter == 0) {
                System.out.println("Level " + level);
            }
            if (level == 1) {
                System.out.print("Guess a number (1-100): ");
            } else if (level == 2) {
                System.out.print("Guess a number (1-200): ");
            } else if (level == 3) {
                System.out.print("Guess a number (1-300): ");
            } else if (level == 4) {
                System.out.print("Guess a number (1-400): ");
            } else if (level == 5) {
                System.out.print("Guess a number (1-500): ");
            }


            String playerInput = scanner.nextLine();
            inputCounter++;

            int playerNumber;

            boolean isValid = true;


            for (int i = 0; i < playerInput.length(); i++) {
                if (playerInput.charAt(i) < 48 || playerInput.charAt(i) > 57) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                playerNumber = Integer.parseInt(playerInput);
                if (playerNumber == computerNumber) {
                    System.out.println("You guessed it!");
                    if (level != 5) {
                        System.out.println();
                    }

                    inputCounter = 0;

                    if (level == 5) {
                        break;
                    }
                    level++;
                    if (level == 2) {
                        computerNumber = randomNumber.nextInt(200);
                    } else if (level == 3) {
                        computerNumber = randomNumber.nextInt(300);
                    } else if (level == 4) {
                        computerNumber = randomNumber.nextInt(400);
                    } else if (level == 5) {
                        computerNumber = randomNumber.nextInt(500);
                    }
                } else if (playerNumber > computerNumber) {
                    System.out.println("Too High!");
                } else {
                    System.out.println("Too Low!");
                }
            } else {
                System.out.println("Invalid input.");
            }

        }
    }
}


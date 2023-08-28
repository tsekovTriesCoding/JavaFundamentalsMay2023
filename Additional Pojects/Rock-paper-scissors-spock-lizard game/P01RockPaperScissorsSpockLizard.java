package A4ExerciseDataTypesAndVariables.Projects;

import java.util.Random;
import java.util.Scanner;

public class P01RockPaperScissorsSpockLizard {
    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";
    private static final String SPOCK = "Spock";
    private static final String Lizard = "lizard";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose [r]ock, [p]aper, [s]cissors, [S]pock or [l]izard: ");
        String playerMove = scanner.nextLine();

        if (playerMove.equals("r") || playerMove.equals("Rock") || playerMove.equals("rock")) {
            playerMove = "rock";
        } else if (playerMove.equals("p") || playerMove.equals("Paper") || playerMove.equals("paper")) {
            playerMove = "paper";
        } else if (playerMove.equals("s") || playerMove.equals("Scissors") || playerMove.equals("scissors")) {
            playerMove = "scissors";
        } else if (playerMove.equals("S") || playerMove.equals("Spock") || playerMove.equals("spock")) {
            playerMove = "Spock";
        } else if (playerMove.equals("l") || playerMove.equals("Lizard") || playerMove.equals("lizard")) {
            playerMove = "lizard";
        } else {
            System.out.println("Invalid input. Try again...");
            return;
        }

        Random random = new Random();
        int computerRandomNumber = random.nextInt(6);
        String computerMove = "";

        switch (computerRandomNumber) {
            case 1:
                computerMove = "rock";
                break;
            case 2:
                computerMove = "scissors";
                break;
            case 3:
                computerMove = "paper";
                break;
            case 4:
                computerMove = "Spock";
                break;
            case 5:
                computerMove = "lizard";
                break;
        }

        System.out.printf("The computer chose %s%n", computerMove);

        if (playerMove.equals("rock") && computerMove.equals("scissors") ||
                playerMove.equals("paper") && computerMove.equals("rock") ||
                playerMove.equals("scissors") && computerMove.equals("paper") ||
                playerMove.equals("rock") && computerMove.equals("lizard") ||
                playerMove.equals("paper") && computerMove.equals("Spock") ||
                playerMove.equals("scissors") && computerMove.equals("lizard") ||
                playerMove.equals("Spock") && computerMove.equals("rock") ||
                playerMove.equals("Spock") && computerMove.equals("scissors") ||
                playerMove.equals("lizard") && computerMove.equals("paper") ||
                playerMove.equals("lizard") && computerMove.equals("Spock")) {
            System.out.println("You win");
        } else if (playerMove.equals("rock") && computerMove.equals("paper") ||
                playerMove.equals("paper") && computerMove.equals("scissors") ||
                playerMove.equals("scissors") && computerMove.equals("rock") ||
                playerMove.equals("lizard") && computerMove.equals("rock") ||
                playerMove.equals("Spock") && computerMove.equals("paper") ||
                playerMove.equals("lizard") && computerMove.equals("scissors") ||
                playerMove.equals("rock") && computerMove.equals("Spock") ||
                playerMove.equals("scissors") && computerMove.equals("Spock") ||
                playerMove.equals("paper") && computerMove.equals("lizard") ||
                playerMove.equals("Spock") && computerMove.equals("lizard")) {
            System.out.println("You lose");
        } else {
            System.out.println("This game was a draw");
        }
    }
}

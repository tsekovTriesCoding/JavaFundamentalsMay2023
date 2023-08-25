package A18ExerciseTextProcessing.MoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String articleTitle = scanner.nextLine();
        String articleContent = scanner.nextLine();
        String command = scanner.nextLine();

        List<String> commentsList = new ArrayList<>();
        while (!command.equals("end of comments")) {
            String comment = command;

            commentsList.add(comment);
            command = scanner.nextLine();
        }

        System.out.printf("<h1>%n    %s%n</h1>%n", articleTitle);
        System.out.printf("<article>%n    %s%n</article>%n", articleContent);
        for (String comment : commentsList) {
            System.out.printf("<div>%n    %s%n</div>%n", comment);
        }

    }
}

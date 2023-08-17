package A14ExerciseObjectsAndClasses.Exercise.P02Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] article = scanner.nextLine().split(", ");

        String title = article[0];
        String content = article[1];
        String author = article[2];

        Article currentArticle = new Article(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String command = input.split(" ")[0];

            if (command.equals("Edit:")) {
                String newContent = input.split(": ")[1];
                currentArticle.editContent(newContent);

            } else if (command.equals("ChangeAuthor:")) {
                String newAuthor = input.split(": ")[1];
                currentArticle.changeAuthor(newAuthor);

            } else if (command.equals("Rename:")) {
                String newTitle = input.split(": ")[1];
                currentArticle.rename(newTitle);
            }

        }

        System.out.println(currentArticle);
    }
}

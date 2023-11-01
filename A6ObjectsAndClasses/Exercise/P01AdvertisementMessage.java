package A6ObjectsAndClasses.Exercise;

import java.util.Random;
import java.util.Scanner;

public class P01AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfMessages = Integer.parseInt(scanner.nextLine());

        String[] phrases = new String[]{"Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product."};

        String[] events = new String[]{"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};

        String[] authors = new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};

        String[] cities = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random rnd = new Random();
        for (int i = 1; i <= numberOfMessages; i++) {

            String randomPhrase = phrases[rnd.nextInt(phrases.length)];
            String randomEvent = events[rnd.nextInt(events.length)];
            String randomAuthor = authors[rnd.nextInt(authors.length)];
            String randomCity = cities[rnd.nextInt(cities.length)];

            System.out.printf("%s %s %s – %s%n", randomPhrase, randomEvent, randomAuthor, randomCity);
        }
    }
}

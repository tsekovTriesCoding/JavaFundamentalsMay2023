package A14ExerciseObjectsAndClasses.Exercise.P06OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> peopleList = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String name = input.split("\\s+")[0];
            String id = input.split("\\s+")[1];
            int age = Integer.parseInt(input.split("\\s+")[2]);

            Person person = new Person(name, id, age);

            peopleList.add(person);

            input = scanner.nextLine();
        }

        peopleList.sort(Comparator.comparing(Person::getAge));

        for (Person person : peopleList) {

            System.out.printf("%s with ID: %s is %d years old.%n", person.getName(), person.getId(), person.getAge());
        }
    }
}

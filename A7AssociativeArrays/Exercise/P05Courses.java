package A16AssociativeArraysAndLambdaAndStreamAPI.Exercise;

import java.sql.SQLOutput;
import java.util.*;

public class P05Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, List<String>> coursesMap = new LinkedHashMap<>();
        while (!input.equals("end")) {

            String courseName = input.split(" : ")[0];
            String studentName = input.split(" : ")[1];

            if (!coursesMap.containsKey(courseName)) {
                coursesMap.put(courseName, new ArrayList<>());
                List<String> studentsList = coursesMap.get(courseName);
                studentsList.add(studentName);
            } else {
                List<String> studentsList = coursesMap.get(courseName);
                studentsList.add(studentName);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : coursesMap.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue().size());
            for (String name : entry.getValue()) {
                System.out.println("-- " + name);
            }
        }

    }
}

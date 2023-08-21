package A16AssociativeArraysAndLambdaAndStreamAPI.Exercise;

import java.util.*;

public class P06StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<Double>> studentsMap = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!studentsMap.containsKey(studentName)) {
                studentsMap.put(studentName, new ArrayList<>());
                List<Double> gradesList = studentsMap.get(studentName);
                gradesList.add(grade);
            } else {
                List<Double> gradesList = studentsMap.get(studentName);
                gradesList.add(grade);
            }

        }

        double avgGradeOfStudent = 0;

        for (Map.Entry<String, List<Double>> entry : studentsMap.entrySet()) {
            double gradesSum = 0;
            for (double grade : entry.getValue()) {
                gradesSum += grade;
            }
            avgGradeOfStudent = gradesSum / entry.getValue().size();
            if (avgGradeOfStudent >= 4.5) {
                System.out.printf("%s -> %.2f\n", entry.getKey(), avgGradeOfStudent);
            }
        }

    }
}

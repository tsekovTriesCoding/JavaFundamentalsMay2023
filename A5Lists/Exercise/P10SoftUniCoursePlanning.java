package A11ExerciseList.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessons = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("course start")) {

            if (command.startsWith("Add")) {
                String lessonToAdd = (command.split(":")[1]);

                if (!lessons.contains(lessonToAdd)) {
                    lessons.add(lessonToAdd);
                }
            } else if (command.startsWith("Insert")) {
                String lessonToInsert = (command.split(":")[1]);
                int indexToInsertAt = Integer.parseInt(command.split(":")[2]);

                if (!lessons.contains(lessonToInsert)) {
                    lessons.add(indexToInsertAt, lessonToInsert);
                }
            } else if (command.startsWith("Remove")) {
                String lessonToRemove = (command.split(":")[1]);

                lessons.remove(lessonToRemove);
            } else if (command.startsWith("Swap")) {
                String lesson1 = (command.split(":")[1]);
                String lesson2 = (command.split(":")[2]);

                if (lessons.contains(lesson1) && lessons.contains(lesson2)) {
                    //lessons.remove(lesson2);
                    //lessons.add(lesson1);
                    //lessons.remove(0);
                    //lessons.add(0, lesson2);
                    Collections.swap(lessons, lessons.indexOf(lesson1), lessons.indexOf(lesson2));

                    int indexOfLesson1 = lessons.indexOf(lesson1);
                    int indexOfLesson2 = lessons.indexOf(lesson2);

                    if (lessons.contains(lesson1 + "-Exercise")) {
                        String exerciseName = lesson1 + "-Exercise";
                        lessons.remove(exerciseName);

                        if (indexOfLesson1 + 1 <= lessons.size() - 1) {
                            lessons.add(indexOfLesson1 + 1, exerciseName);
                        } else {
                            lessons.add(exerciseName);
                        }
                    }

                    if (lessons.contains(lesson2 + "-Exercise")) {
                        String exerciseName = lesson2 + "-Exercise";
                        lessons.remove(exerciseName);

                        if (indexOfLesson2 + 1 <= lessons.size() - 1) {
                            lessons.add(indexOfLesson2 + 1, exerciseName);
                        } else {
                            lessons.add(exerciseName);
                        }
                    }
                }
            } else if (command.startsWith("Exercise")) {
                String lessonToAdd = (command.split(":")[1]);
                String lessonExercise = lessonToAdd + "-Exercise";

                if (lessons.contains(lessonToAdd) && !lessons.contains(lessonExercise)) {
                    lessons.add(lessons.indexOf(lessonToAdd) + 1,lessonExercise);

                } else if (!lessons.contains(lessonToAdd)) {

                    lessons.add(lessonToAdd);
                    lessons.add(lessonExercise);
                }
            }

            command = scanner.nextLine();
        }

        int counter = 1;
        for (String lesson : lessons) {
            System.out.println(counter + "." + lesson);
            counter++;
        }
    }
}

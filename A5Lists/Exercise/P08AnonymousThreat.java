package A11ExerciseList.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> strings = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("3:1")) {

            if (command.contains("merge")) {

                int startIndex = Math.max(0, Integer.parseInt(command.split(" ")[1]));
                int endIndex = Math.min(Integer.parseInt(command.split(" ")[2]), (strings.size() - 1));

                // проверяваме дали индексите са валидни:
                if (startIndex <= strings.size() - 1 && endIndex >= 0 && endIndex <= strings.size() - 1) {
                    //{"Ivo", "Johny", "Tony", "Bony", "Mony"}
                    //merge 1 3
                    //взимаме елементите и ги обединяваме
                    String combinedString = ""; //резултат от обединението на елементите
                    for (int index = startIndex; index <= endIndex; index++) {
                        String currentElement = strings.get(index);
                        combinedString += currentElement;
                    }
                    //combinedString = "JohnyTonyBony"
                    //премахваме обединените елементи
                    for (int index = startIndex; index <= endIndex; index++) {
                        strings.remove(startIndex);
                    }
                    //{"Ivo", "Mony"}

                    //добавяме обединението на  позиция startIndex
                    strings.add(startIndex, combinedString);
                    // стрингът става: {"Ivo", "JohnyTonyBony", "Mony"}
                }

            } else if (command.contains("divide")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                int portions = Integer.parseInt(command.split(" ")[2]);

                //индексът трябва да е валиден:
                if (index >= 0 && index <= strings.size() - 1) {
                    //{"Ivo", "Tony", "Mony"}
                    // примерна команда: divide 0 3

                    String stringToDivide = strings.get(index); //"Ivo"- взимам елемента на дадения индекс
                    strings.remove(index); // и после го премахвам

                    // проверявам колко символа ще има всяка част
                    int symbolsPerPart = stringToDivide.length() / portions;

                    // цикъл за всички равни части,без последната (по условие)
                    int beginIndex = 0; //индекс в текста за деление
                    for (int i = 1; i < portions; i++) {
                        String textPerPart = stringToDivide.substring(beginIndex, beginIndex + symbolsPerPart);
                        strings.add(index, textPerPart);
                        index++; //място на поставяне на разбитата част в главния списък
                        beginIndex += symbolsPerPart;
                    }

                    //последната част,която е най_дълга (по условие)
                    String stringLastPart = stringToDivide.substring(beginIndex, stringToDivide.length());
                    strings.add(index, stringLastPart);
                }

            }
            command = scanner.nextLine();
        }

        System.out.println(String.join(" ", strings));

    }
}

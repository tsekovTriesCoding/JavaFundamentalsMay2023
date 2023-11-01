package A8TextProcessing.Exercise;

import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int indexLast = input.lastIndexOf("\\");
        String fullFileName = input.substring(indexLast + 1);

        int pointIndex = fullFileName.indexOf(".");
        String fileName = fullFileName.substring(0, pointIndex);
        String extension = fullFileName.substring(pointIndex + 1);

        System.out.printf("File name: %s\n", fileName);
        System.out.printf("File extension: %s", extension);
    }
}

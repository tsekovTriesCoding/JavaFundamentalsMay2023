package A4Methods.MoreExercises;

import java.util.*;

public class P06ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commandParts = command.split(" ");
            String commandType = commandParts[0];

            if (commandType.equals("exchange")) {
                int index = Integer.parseInt(commandParts[1]);
                int n = numbers.length;

                if (index >= 0 && index <= n - 1) {

                    int[] newNumbers = new int[n];

                    int[] firstPart = new int[index];
                    firstPart = Arrays.copyOfRange(numbers, 0, index + 1);
                    int[] secondPart = new int[n - index];
                    secondPart = Arrays.copyOfRange(numbers, index + 1, n);

                    System.arraycopy(secondPart, 0, newNumbers, 0, secondPart.length);
                    System.arraycopy(firstPart, 0, newNumbers, secondPart.length, firstPart.length);
                    numbers = newNumbers;
                } else {
                    System.out.println("Invalid index");
                }

            } else if (commandType.equals("max")) {
                String evenOrOdd = commandParts[1];

                printMaxEvenOddElement(evenOrOdd, numbers);
            } else if (commandType.equals("min")) {
                String evenOrOdd = commandParts[1];

                printMinEvenOddElement(evenOrOdd, numbers);

            } else if (commandType.equals("first")) {
                int count = Integer.parseInt(commandParts[1]);
                String evenOrOdd = commandParts[2];

                if (count > numbers.length) {
                    System.out.println("Invalid count");
                } else {
                    if (evenOrOdd.equals("even")) {
                        List<Integer> firstEvenNumbers = getFirstEvenNumbers(count, evenOrOdd, numbers);
                        System.out.println(firstEvenNumbers);

                    } else if (evenOrOdd.equals("odd")) {
                        List<Integer> firstOddNumbers = getFirstOddNumbers(count, evenOrOdd, numbers);
                        System.out.println(firstOddNumbers);
                    }
                }

            } else if (commandType.equals("last")) {
                int count = Integer.parseInt(commandParts[1]);
                String evenOrOdd = commandParts[2];

                if (count > numbers.length) {
                    System.out.println("Invalid count");
                } else {
                    if (evenOrOdd.equals("even")) {
                        List<Integer> lastEvenNumbers = getLastEvenNumbers(count, evenOrOdd, numbers);

                        System.out.println(lastEvenNumbers);

                    } else if (evenOrOdd.equals("odd")) {
                        List<Integer> lastOddNumbers = getLastOddNumbers(count, evenOrOdd, numbers);

                        System.out.println(lastOddNumbers);
                    }
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(Arrays.toString(numbers));
    }

    public static void printMaxEvenOddElement(String command, int[] numbers) {
        int maxNum = Integer.MIN_VALUE;
        int indexOfMaxEvenNum = - 1;
        int indexOfMaxOddNum = - 1;

        if (command.equals("even")) {
            for (int i = 0; i <= numbers.length - 1; i++) {
                if (numbers[i] % 2 == 0 && maxNum < numbers[i]) {
                    maxNum = numbers[i];
                    indexOfMaxEvenNum = i;
                }
            }
            if (indexOfMaxEvenNum >= 0) {
                System.out.println(indexOfMaxEvenNum);
            } else {
                System.out.println("No matches");
            }
        } else if (command.equals("odd")) {
            for (int i = 0; i <= numbers.length - 1; i++) {
                if (numbers[i] % 2 != 0 && maxNum < numbers[i]) {
                    maxNum = numbers[i];
                    indexOfMaxOddNum = i;
                }
            }
            if (indexOfMaxOddNum >= 0) {
                System.out.println(indexOfMaxOddNum);
            } else {
                System.out.println("No matches");
            }
        }
    }

    public static void printMinEvenOddElement(String command, int[] numbers) {
        int minNum = Integer.MAX_VALUE;
        int indexOfMinEvenNum = -1;
        int indexOfMinOddNum = -1;

        if (command.equals("even")) {
            for (int i = 0; i <= numbers.length - 1; i++) {
                if (numbers[i] % 2 == 0 && minNum > numbers[i]) {
                    minNum = numbers[i];
                    indexOfMinEvenNum = i;
                }
            }
            if (indexOfMinEvenNum >= 0) {
                System.out.println(indexOfMinEvenNum);
            } else {
                System.out.println("No matches");
            }
        } else if (command.equals("odd")) {
            for (int i = 0; i <= numbers.length - 1; i++) {
                if (numbers[i] % 2 != 0 && minNum > numbers[i]) {
                    minNum = numbers[i];
                    indexOfMinOddNum = i;
                }
            }
            if (indexOfMinOddNum >= 0) {
                System.out.println(indexOfMinOddNum);
            } else {
                System.out.println("No matches");
            }
        }
    }

    public static List<Integer> getFirstEvenNumbers(int count, String even, int[] numbers) {

        List<Integer> firstEvenNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number % 2 != 0) {
                firstEvenNumbers.add(number);

                if (firstEvenNumbers.toArray().length == count) {
                    break;
                }
            }
        }

        return firstEvenNumbers;
    }

    public static List<Integer> getFirstOddNumbers(int count, String odd, int[] numbers) {

        List<Integer> firstOddNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number % 2 != 0) {
                firstOddNumbers.add(number);

                if (firstOddNumbers.toArray().length == count) {
                    break;
                }
            }
        }

        return firstOddNumbers;
    }

    public static List<Integer> getLastEvenNumbers(int count, String even, int[] numbers) {

        int[] lastEvenNumbers = new int[count];

        int index = 0;

        for (int i = numbers.length - 1; i >= 0; i--) {
            int num = numbers[i];

            if (num % 2 == 0 && index < lastEvenNumbers.length) {
                lastEvenNumbers[index] = num;
                index++;
            }
        }

        List<Integer> lastEvenNumbersEdited = new ArrayList<>();

        for (int i = 0; i <= lastEvenNumbers.length - 1; i++) {
            if (lastEvenNumbers[i] != 0) {
                lastEvenNumbersEdited.add(lastEvenNumbers[i]);
            }
        }

        return lastEvenNumbersEdited;
    }

    public static List<Integer> getLastOddNumbers(int count, String even, int[] numbers) {
        int[] lastOddNumbers = new int[count];

        int index = 0;

        for (int i = numbers.length - 1; i >= 0; i--) {
            int num = numbers[i];

            if (num % 2 != 0 && index < lastOddNumbers.length) {
                lastOddNumbers[index] = num;
                index++;
            }
        }

        List<Integer> lastOddNumbersEdited = new ArrayList<>();

        for (int i = 0; i <= lastOddNumbers.length - 1; i++) {
            if (lastOddNumbers[i] != 0) {
                lastOddNumbersEdited.add(lastOddNumbers[i]);
            }
        }

        return lastOddNumbersEdited;
    }
}
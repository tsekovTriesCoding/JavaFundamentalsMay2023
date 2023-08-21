package A16AssociativeArraysAndLambdaAndStreamAPI.Exercise;

import java.util.*;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, List<String>> employeesMap = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String companyName = input.split(" -> ")[0];
            String employeeId = input.split(" -> ")[1];

            if (!employeesMap.containsKey(companyName)) {
                employeesMap.put(companyName, new ArrayList<>());
                List<String> employeesIds = employeesMap.get(companyName);
                employeesIds.add(employeeId);
            } else {
                if (!employeesMap.get(companyName).contains(employeeId)) {
                    List<String> employeesIds = employeesMap.get(companyName);
                    employeesIds.add(employeeId);
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : employeesMap.entrySet()) {
            System.out.println(entry.getKey());
            for (String id : entry.getValue()) {
                System.out.println("-- " + id);
            }
        }

    }
}

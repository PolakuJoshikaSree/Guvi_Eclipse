package packageOne;
import java.util.*;

public class CompanyEmployeeMap {

    public static void main(String[] args) {
        Map<String, List<String>> companyMap = new HashMap<>();
        companyMap.put("TCS", new ArrayList<>(Arrays.asList("Amit", "Sonia", "Ravi")));
        companyMap.put("Infosys", new ArrayList<>(Arrays.asList("Neha", "Arjun", "Priya")));
        companyMap.put("Wipro", new ArrayList<>(Arrays.asList("Vikram", "Simran", "Raj")));
        companyMap.put("HCL", new ArrayList<>(Arrays.asList("Shreya", "Karan", "Pooja")));
        companyMap.put("IBM", new ArrayList<>(Arrays.asList("Anil", "Geeta", "Ramesh")));

        System.out.println("Company -> Employees:");
        for (Map.Entry<String, List<String>> entry : companyMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        companyMap.putIfAbsent("Cognizant", new ArrayList<>(Arrays.asList("John", "Ram", "Lisa")));

        List<String> cognizantEmployees = companyMap.get("Cognizant");
        if (cognizantEmployees != null) {
            if (cognizantEmployees.contains("Ram")) {
                System.out.println("\nRam is working in Cognizant");
            } else {
                System.out.println("\nRam is not found in Cognizant");
            }
        } else {
            System.out.println("\nCognizant company not found");
        }
        System.out.println("\nUpdated Company -> Employees:");
        for (Map.Entry<String, List<String>> entry : companyMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
package Static&Final.Level1;

public class Employee {

    private static String companyName = "Nvidia Corp.";
    private static int totalEmployees = 0;
    private final String id;
    private String name;
    private String designation;

    public static void main(String[] args) {
        System.out.println("Welcome to " + Employee.companyName + "!");

        Employee emp1 = new Employee("NVI001", "Arihant Jain", "Sr. Software Engineer");
        Employee emp2 = new Employee("NVI002", "Suryansh", "Simulation Technology");
        Employee emp3 = new Employee("NVI003", "Arjun Raghav", "GPU Engineer");

        if (emp1 instanceof Employee) {
            System.out.println("\nVerifying emp1 type using instanceof:");
            emp1.displayEmployeeDetails();
        }

        if (emp2 instanceof Employee) {
            emp2.displayEmployeeDetails();
        }
        if (emp3 instanceof Employee) {
            emp3.displayEmployeeDetails();
        }

        Employee.displayTotalEmployees();

        Object someOtherObject = "Not an Employee";
        if (someOtherObject instanceof Employee) {
            System.out.println("\nsomeOtherObject is an instance of Employee.");
        } else {
            System.out.println("\nsomeOtherObject is NOT an instance of Employee.");
        }
    }

    public Employee(String id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public static void displayTotalEmployees() {
        System.out.println("\n--- Company Statistics ---");
        System.out.println("Company Name: " + companyName);
        System.out.println("Total Employees: " + totalEmployees);
        System.out.println("----------------------------");
    }

    public void displayEmployeeDetails() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("Company: " + companyName);
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("--------------------------");
    }
}
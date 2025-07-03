import java.util.ArrayList;
import java.util.List;

interface Department {
    void assignDept(String dName);
    String getDeptDetails();
}

abstract class Employee {
    private String empID;
    private String name;
    private double baseSal;

    public Employee (String empID, String name, double baseSal) {
        this.empID = empID;
        this.name = name;
        this.baseSal = baseSal;
    }

    public String getEmpID() {
        return empID;
    }
    public void setEmployeeId(String employeeId) { this.empID = empID; }

    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }

    public double getBaseSal() {
        return baseSal;
    }
    public void setBaseSal(double baseSal) { this.baseSal = baseSal; }

    public abstract double calculateSalary();

    void displayDetails() {
        System.out.println("ID : " + empID + "\nName : " + name + "\nBase Salary : " + baseSal);
    }
}

class FullTimeEmployee extends Employee implements Department {
    private final double bonus;
    private String department;

    public FullTimeEmployee (String empId, String name, double baseSal, double bonus) {
        super(empId,name,baseSal);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSal() + bonus;
    }

    @Override
    public void assignDept(String dDame) {
        this.department = dDame;
    }

    @Override
    public String getDeptDetails() {
        return department;
    }
}

class PartTimeEmployee extends Employee implements Department {
    private int workingHours;
    private double hourlyRate;
    private String department;

    public PartTimeEmployee (String empID, String name, double baseSal, int workingHours, double hourlyRate) {
        super(empID,name,baseSal);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return getBaseSal() + (workingHours * hourlyRate * 30);
    }

    @Override
    public void assignDept(String dDame) {
        this.department = dDame;
    }

    @Override
    public String getDeptDetails() {
        return department;
    }
}

//---------------------------------------------------------------------

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        ArrayList<Employee> emp = new ArrayList<>();

        FullTimeEmployee fte1 = new FullTimeEmployee("F001", "Arihant Jain", 88500, 25000);
        fte1.assignDept("DevOps");

        FullTimeEmployee fte2 = new FullTimeEmployee("F002", "Suryansh", 92000, 22500.25);
        fte2.assignDept("SDE");

        PartTimeEmployee pte = new PartTimeEmployee("P001", "Arjun Raghav",10000,9,99);
        pte.assignDept("Intern");

        emp.add(fte1);
        emp.add(fte2);
        emp.add(pte);

        for (Employee e : emp) {
            e.displayDetails();
            if (e instanceof Department) {
                System.out.println("Total Salary : " + e.calculateSalary());
                System.out.println("Department : " + ((Department) e).getDeptDetails());
            }
            System.out.println("\n");
        }
    }
}



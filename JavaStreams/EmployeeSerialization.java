import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "ID=" + id +
               ", Name='" + name + '\'' +
               ", Department='" + department + '\'' +
               ", Salary=" + salary +
               '}';
    }
}

public class EmployeeSerialization {
    private static final String FILE_NAME = "employees.ser";

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "A", "HR", 50000));
        employeeList.add(new Employee(102, "B", "IT", 60000));
        employeeList.add(new Employee(103, "C", "Sales", 55000));

        saveEmployees(employeeList);
        List<Employee> retrievedEmployees = loadEmployees();

        System.out.println("Deserialized Employees:");
        for (Employee emp : retrievedEmployees) {
            System.out.println(emp);
        }
    }

    public static void saveEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees have been serialized to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error while serializing employees.");
            e.printStackTrace();
        }
    }

    public static List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
        } catch (IOException e) {
            System.out.println("Error while deserializing employees.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Employee class not found.");
            e.printStackTrace();
        }
        return employees;
    }
}

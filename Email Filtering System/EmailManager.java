import java.util.ArrayList;
import java.util.List;

public class EmailManager {

    private final List<Employee> employees;

    public EmailManager() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String email) {
        try {
            Email eMail = new Email(email);
            if (eMail.isValid()) {
                employees.add(new Employee(name,eMail));
                System.out.println("\nEmployee : " + name + " Added to DB.");
            }
        } catch (InvalidEmailFormatException iefe) {
            System.err.println("\nInvalid Email for " + name + ": " + iefe.getMessage());
        }
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public List<Employee> searchByDomain(String domainName) throws NoEmployeeFoundException {
        List<Employee> result = new ArrayList<>();

        for (Employee e : employees) {
            if (e.getEmail().getEmailAddress().toLowerCase().endsWith("@" + domainName.toLowerCase())) {
                result.add(e);
            }
        }

        if (result.isEmpty()) {
            throw new NoEmployeeFoundException("\nNo Employees for domain: " + domainName);
        }

        return result;
    }
}
public class EmployeeManagementSystem {
    public static void main(String[] args) {

        Manager m1 = new Manager("Arihant Jain", 7,345676.65, 3);
        m1.displayDetails();
        System.out.println();

        Developer d1 = new Developer("Suryansh", 2,216212.75,"Python");
        d1.displayDetails();
        System.out.println();

        Intern i1 = new Intern("Arjun Raghav", 5,188457.99,5);
        i1.displayDetails();
        System.out.println();

    }
}

class Employee {
    String name;
    int id;
    double salary;

    Employee (String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee Name : " + name);
        System.out.println("Employee Id : " + id);
        System.out.println("Employee Salary : ₹ " + salary);
    }
}

class Manager extends Employee {
    int teamSize;

    Manager (String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Size of team : " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming language : " + programmingLanguage);
    }
}

class Intern extends Employee {
    int internSince;

    Intern(String name,int id, double salary, int internSince) {
        super(name, id, salary);
        this.internSince = internSince;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Intern since : " + internSince + " years");
    }
}
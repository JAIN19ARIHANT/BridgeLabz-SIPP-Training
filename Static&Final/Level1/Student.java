package Static&Final.Level1;

public class Student {

    private static String universityName = "GLA University";
    private static int totalStudents = 0;
    private final String rollNumber;
    private String name;
    private char grade;

    public static void main(String[] args) {
        System.out.println("Welcome to " + Student.universityName + " student portal!");

        Student student1 = new Student("S001", "Arihant Jain", 'A');
        Student student2 = new Student("S002", "Suryansh", 'B');
        Student student3 = new Student("S003", "Anubhav Yadav", 'C');

        if (student1 instanceof Student) {
            System.out.println("\nChecking student1 type using instanceof:");
            student1.displayStudentDetails();
        }

        if (student2 instanceof Student) {
            student2.displayStudentDetails();
        }
        if (student3 instanceof Student) {
            student3.displayStudentDetails();
        }

        Student.displayTotalStudents();

        Object randomObject = new String("Not a student");
        if (randomObject instanceof Student) {
            System.out.println("\nrandomObject is an instance of Student.");
        } else {
            System.out.println("\nrandomObject is NOT an instance of Student.");
        }

        if (student1 instanceof Student) {
            student1.updateGrade('O');
            student1.displayStudentDetails();
        }
    }

    public Student(String rollNumber, String name, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public char getGrade() {
        return grade;
    }

    public void updateGrade(char newGrade) {
        if (newGrade >= 'A' && newGrade <= 'F') {
            this.grade = newGrade;
            System.out.println(this.name + "'s grade updated to: " + this.grade);
        } else {
            System.out.println("Invalid grade. Grade must be A-F.");
        }
    }

    public static void displayTotalStudents() {
        System.out.println("\n--- University Statistics ---");
        System.out.println("University Name: " + universityName);
        System.out.println("Total Students Enrolled: " + totalStudents);
        System.out.println("-------------------------------");
    }

    public void displayStudentDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("University: " + universityName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
        System.out.println("-------------------------");
    }
}

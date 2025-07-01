public class SchoolSystem {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mrs. Sharma", 35, "Mathematics");
        Student student = new Student("Rahul", 16, "10th class");
        Staff staff = new Staff("Mr. Verma", 40, "Librarian");

        teacher.displayRole();
        student.displayRole();
        staff.displayRole();
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Teacher extends Person {
    String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayRole() {
        System.out.println("Teacher");
        System.out.println("Name: " + name + ", Age: " + age + ", Subject: " + subject + "\n");
    }
}

class Student extends Person {
    String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayRole() {
        System.out.println("Student");
        System.out.println("Name: " + name + ", Age: " + age + ", Grade: " + grade + "\n");
    }
}

class Staff extends Person {
    String designation;

    public Staff(String name, int age, String designation) {
        super(name, age);
        this.designation = designation;
    }

    public void displayRole() {
        System.out.println("Staff");
        System.out.println("Name: " + name + ", Age: " + age + ", Designation: " + designation + "\n");
    }
}
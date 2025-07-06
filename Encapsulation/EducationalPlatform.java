import java.util.*;

class User {
    String name;
    int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String showDashboard() {
        return "Name : " + name + "\nAge : " + age;
    }
}

class Student extends User {
    List<String> enrolledCourse;
    int courseDuration;

    public Student (String name, int age, List<String> enrolledCourse, int courseDuration) {
        super(name,age);
        this.enrolledCourse = enrolledCourse;
        this.courseDuration = courseDuration;
    }

    @Override
    public String showDashboard() {
        return super.showDashboard() +
                "\nEnrolled Courses : " + String.join(", " ,enrolledCourse) +
                "\nTotal Duration : " + courseDuration + " Months";
    }
}

class Instructor extends User {
    String instructingCourse;
    int courseDuration;

    public Instructor (String name, int age, String instructingCourse, int courseDuration) {
        super(name,age);
        this.instructingCourse = instructingCourse;
        this.courseDuration = courseDuration;
    }

    @Override
    public String showDashboard() {
        return "Name : " + name +
                "\nAge : " + age +
                "\nInstructing Course : " + instructingCourse +
                "\nDuration : " + courseDuration + " Months";
    }
}

public class EducationalPlatform {
    public static void main(String[] args) {
        List<String> courses1 = List.of("Java","SQL","Full-Stack");
        Student s1 = new Student("Arihant Jain",22,courses1,6);

        Student s2 = new Student("Suryansh",23,List.of("Python","AI"),6);

        Instructor i1 = new Instructor("Mr. Sohil Khan",27,"Java",6);
        Instructor i2 = new Instructor("Mr. Monu Kumar",31,"AI",6);

        System.out.println("\n🧑‍🎓 Students:");
        System.out.println(s1.showDashboard() + "\n");
        System.out.println(s2.showDashboard() + "\n");
        System.out.println("------------------------------------");

        System.out.println("\n👩‍🏫 Instructors: ");
        System.out.println(i1.showDashboard() + "\n");
        System.out.println(i2.showDashboard());
        System.out.println("------------------------------------");

    }
}
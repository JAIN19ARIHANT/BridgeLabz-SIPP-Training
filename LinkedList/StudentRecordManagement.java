import java.util.Scanner;

class Student {
    int roll;
    String name;
    int age;
    char grade;
    Student next;

    Student (int roll, String name, int age, char grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.name = name;
    }
}

class StudentList {
    Student head = null;

    public void addStudent (int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);

        if (head == null) {
            head = newStudent;
        }else {
            Student temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newStudent;
        }
    }

    public void deleteStudent(int roll) {
        if (head.roll == roll) {
            head = head.next;
        }
        else {
            Student temp = head;
            while (temp.next != null && temp.next.roll != roll) {
                temp = temp.next;
            }
            if (temp.next == null) {
                System.out.println("Student Not found !!");
            }else {
                temp.next = temp.next.next;
            }
        }
    }

    public void searchStudent (int roll) {
        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Student Name : " + temp.name + "\nRoll No. : " + roll + "\nAge : " + head.age + "\nGrade : " + head.grade);
                return;
            }
            else temp = temp.next;
        }
        System.out.println("Student not found !!");
    }

    public void updateGrade (int roll, char newGrade) {
        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = newGrade;
                return;
            }
            else
                temp = temp.next;
        }
        System.out.println("Student not found !!");
    }

    public void displayAll () {
        Student temp = head;

        while (temp != null) {
            System.out.println("Student Name : " + temp.name + "\nRoll No. : " + temp.roll + "\nAge : " + head.age + "\nGrade : " + head.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update Grade");
            System.out.println("5. Display All");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (ch) {
                case 1:
                    System.out.print("Roll: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Grade: ");
                    char grade = sc.nextLine().charAt(0);
                    list.addStudent(roll, name, age, grade);
                    break;

                case 2:
                    System.out.print("Enter roll to delete: ");
                    int delRoll = sc.nextInt();
                    list.deleteStudent(delRoll);
                    break;

                case 3:
                    System.out.print("Enter roll to search: ");
                    int searchRoll = sc.nextInt();
                    list.searchStudent(searchRoll);
                    break;

                case 4:
                    System.out.print("Enter roll to update grade: ");
                    int updateRoll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new grade: ");
                    char newGrade = sc.nextLine().charAt(0);
                    list.updateGrade(updateRoll, newGrade);
                    break;

                case 5:
                    list.displayAll();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
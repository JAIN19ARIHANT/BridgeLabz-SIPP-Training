import java.io.*;
import java.util.ArrayList;
import java.util.List;

//student details (roll number, name, GPA) 
class Student implements Serializable{
    private String name;
    private int rollNumber;
    private double GPA;
    public Student(String name,int rollNumber,double GPA){
        this.name = name;
        this.rollNumber = rollNumber;
        this.GPA = GPA;
    }
    public String getName(){
        return name;
    }
    public int getRollNumber(){
        return rollNumber;
    }
    public double getGPA(){
        return GPA;
    }
    @Override
    public String toString() {
        return "Name : " + name +"\nrollnumber : " + rollNumber + "\nGPA :" + GPA +"\n";
    }
}

public class StudentsDetails {
    private static final String souFiles = "source.txt";
    private static final String desFiles = "destination.txt";

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("A", 1, 8.50));
        studentList.add(new Student("B", 2, 9.00));
        studentList.add(new Student("C", 3, 9.50));

        writes(studentList);
        
        
        List<Student> retrieveStudents = loadStudents();

        System.out.println("Deserialized Employees:");
        for (Student stu : retrieveStudents) {
            System.out.println(stu);
        }
        
    }

    public static void writes(List<Student> list) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(souFiles))) {
            for (Student s : list) {
                dos.writeUTF(s.getName());
                dos.writeInt(s.getRollNumber());
                dos.writeDouble(s.getGPA());
            }
            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> loadStudents() {
    List<Student> st = new ArrayList<>();
    try (DataInputStream dis = new DataInputStream(new FileInputStream(souFiles))) {
        while (dis.available() > 0) {
            String name = dis.readUTF();
            int roll = dis.readInt();
            double gpa = dis.readDouble();
            st.add(new Student(name, roll, gpa));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return st;
}

    
}


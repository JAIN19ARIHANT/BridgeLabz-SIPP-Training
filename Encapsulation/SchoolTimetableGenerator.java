import java.util.*;

class Employees {
    int id;
    String name;
    String department;

    Employees (int id, String name,String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String generateTimetable() {
        return "Name : " + name + "\nID : " + id + "\nDepartment : " + department;
    }
}

class Teacher extends Employees {
    String subject;

    Teacher (int id, String name,String department,String subject) {
        super(id, name, department);
        this.subject = subject;
    }

    @Override
    public String generateTimetable() {
        return super.generateTimetable() +
                "\nDesignation : Teacher" +
                "\nSubject : " + subject +
                "\nPeriods : 1st, 2nd, 5th\n";
    }
}

class LabAssistant extends Employees {
    String lab;

    LabAssistant (int id, String name,String department,String lab) {
        super(id, name, department);
        this.lab = lab;
    }

    @Override
    public String generateTimetable() {
        return super.generateTimetable() +
                "\nDesignation : Lab Assistant" +
                "\nLab : " + lab +
                "\nPeriods : 3rd, 4th\n";
    }
}

class Coach extends Employees {
    String sport;

    Coach (int id, String name,String department,String sport) {
        super(id, name, department);
        this.sport = sport;
    }

    @Override
    public String generateTimetable() {
        return super.generateTimetable() +
                "\nDesignation : Coach" +
                "\nSport : " + sport +
                "\nPeriods : 6th\n";
    }
}

public class SchoolTimetableGenerator {
    public static void main(String[] args) {
        List<Employees> list = new ArrayList<>();

        Employees t = new Teacher(1,"Alakh Pandey","Science","Physics");
        Employees l = new LabAssistant(99,"Ashwin Anna","Science","Electronics lab");
        Employees c1 = new Coach(7,"Neeraj Chopra","Athletics","Javelin Throw");
        Employees c2 = new Coach(18,"Virat Kholi","Cricket","Cricket");

        list.add(t);
        list.add(l);
        list.add(c1);
        list.add(c2);

        System.out.println("SCHOOL TIMETABLE:");
        for (Employees e : list) {
            System.out.println("--------------------------");
            System.out.println(e.generateTimetable());
        }
    }
}
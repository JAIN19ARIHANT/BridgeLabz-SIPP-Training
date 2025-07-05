import java.util.*;

interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

abstract class Patient implements MedicalRecord {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis;
    List<String> medicalHistory = new ArrayList<>();

    Patient(int patientId, String name, int age, String diagnosis) {
        this.age = age;
        this.name = name;
        this.patientId = patientId;
        this.diagnosis = diagnosis;
    }

    public abstract int calculateBill();

    public String getPatientDetails() {
        return "ID : " + patientId + "\nName : " + name + "\nAge : " + age + "\nDiagnosis : " + diagnosis;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public String viewRecords() {
        return String.join("\n",medicalHistory);
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public int getPatientId() { return patientId; }

}

class InPatient extends Patient {
    private int noOfDays;
    private int dailyCharges;

    public InPatient (int patientId, String name, int age, String diagnosis, int noOfDays, int dailyCharges) {
        super(patientId, name, age, diagnosis);
        this.noOfDays = noOfDays;
        this.dailyCharges = dailyCharges;
    }

    @Override
    public int calculateBill() {
        return noOfDays * dailyCharges;
    }
}


class OutPatient extends Patient {
    private int consultationFee;

    public OutPatient (int patientId, String name, int age, String diagnosis, int consultationFee) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
    }

    @Override
    public int calculateBill() {
        return consultationFee;
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient p1 = new InPatient(1,"Tom Cruise",63,"Fracture",3,20000);
        Patient p2 = new OutPatient(55,"Brad Pitt",61,"Fever",7500);

        p1.addRecord("Back Spasm");
        p1.addRecord("Ligament Tear");
        p2.addRecord("Covid");


        Patient[] patients = { p1, p2 };

        for (Patient p : patients) {
            System.out.println("------------------------");
            System.out.println(p.getPatientDetails());
            System.out.println("Bill : ₹ " + p.calculateBill());
            System.out.println("Medical Records :\n" + p.viewRecords());
            System.out.println("------------------------");
        }
    }
}
package Static&Final.Level1;
public class Patient {

	private static String hospitalName = "AIIMS DELHI";
	private static int totalPatients = 0;
	private final String patientID;
	private String name;
	private int age;
	private String ailment;

	public static void main(String[] args) {
		System.out.println("Welcome to " + Patient.hospitalName);

		Patient patient1 = new Patient("P001", "Arihant Jain", 22, "Fever");
		Patient patient2 = new Patient("P002", "Suryansh", 23, "Cough");
		Patient patient3 = new Patient("P003", "Arjun Raghav", 21, "Migraine");

		if (patient1 instanceof Patient) {
			System.out.println("\nChecking patient1 type using instanceof:");
			patient1.displayPatientDetails();
		}

		if (patient2 instanceof Patient) {
			patient2.displayPatientDetails();
		}
		if (patient3 instanceof Patient) {
			patient3.displayPatientDetails();
		}

		Patient.getTotalPatients();

		Object nonPatientObject = "string";
		if (nonPatientObject instanceof Patient) {
			System.out.println("\nnonPatientObject is an instance of Patient.");
		} else {
			System.out.println("\nnonPatientObject is NOT an instance of Patient.");
		}
	}

	public Patient(String patientID, String name, int age, String ailment) {
		this.patientID = patientID;
		this.name = name;
		this.age = age;
		this.ailment = ailment;
		totalPatients++;
	}

	public String getPatientID() {
		return patientID;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAilment() {
		return ailment;
	}

	public static void getTotalPatients() {
		System.out.println("\n--- Hospital Statistics ---");
		System.out.println("Hospital Name: " + hospitalName);
		System.out.println("Total Patients Admitted: " + totalPatients);
		System.out.println("-----------------------------");
	}

	public void displayPatientDetails() {
		System.out.println("\n--- Patient Details ---");
		System.out.println("Hospital: " + hospitalName);
		System.out.println("Patient ID: " + patientID);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Ailment: " + ailment);
		System.out.println("------------------------");
	}
}

import java.util.*;
public class HospitalDoctorAvailability {
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
            new Doctor("Dr Sharma", "Cardiology", true),
            new Doctor("Dr Rao", "Neurology", false),
            new Doctor("Dr Gupta", "Orthopedics", true),
            new Doctor("Dr Das", "Dermatology", true),
            new Doctor("Dr Iyer", "Pediatrics", false)
        );
        System.out.println("Doctors available on weekends sorted by specialty:");
        doctors.stream()
                .filter(Doctor::isAvailableOnWeekend)
                .sorted(Comparator.comparing(Doctor::getSpecialty))
                .forEach(System.out::println);
    }
    static class Doctor {
        private String name;
        private String specialty;
        private boolean availableOnWeekend;
        public Doctor(String name, String specialty, boolean availableOnWeekend) {
            this.name = name;
            this.specialty = specialty;
            this.availableOnWeekend = availableOnWeekend;
        }
        public String getName() { return name; }
        public String getSpecialty() { return specialty; }
        public boolean isAvailableOnWeekend() { return availableOnWeekend; }
        public String toString() { return name + " - " + specialty + " (Weekend: " + availableOnWeekend + ")"; }
    }
}

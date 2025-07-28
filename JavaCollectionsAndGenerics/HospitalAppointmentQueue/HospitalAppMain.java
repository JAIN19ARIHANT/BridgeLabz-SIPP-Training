public class HospitalAppMain {
    public static void main(String[] args) {
        AppointmentQueue<DoctorAppointment> checkUpQueue = new AppointmentQueue<>();
        AppointmentQueue<LabTestAppointment> labTestQueue = new AppointmentQueue<>();
        AppointmentQueue<XRayAppointment> xRayQueue = new AppointmentQueue<>();

        checkUpQueue.addAppointment(new DoctorAppointment("Arjun", "Dr. Jain", "10:30 AM"));
        checkUpQueue.addAppointment(new DoctorAppointment("Suryansh", "Dr. Jain", "11:15 AM"));
        labTestQueue.addAppointment(new LabTestAppointment("Arjun", "Dr. Jain", "Blood Test", 500));
        xRayQueue.addAppointment(new XRayAppointment("Arjun", "Dr. Jain", "Chest", 750));


        for (DoctorAppointment docApp : checkUpQueue.q) {
            String patient = docApp.getPatientName();
            String doctor = docApp.getDoctorName();

            for (LabTestAppointment labApp : labTestQueue.q) {
                if (labApp.getPatientName().equalsIgnoreCase(patient) &&
                        labApp.getDoctorName().equalsIgnoreCase(doctor)) {

                    System.out.println("Linked Appointments:");
                    System.out.println(docApp.getDetails());
                    System.out.println(labApp.getDetails());
                }
            }

            for (XRayAppointment xrayApp : xRayQueue.q) {
                if (xrayApp.getPatientName().equalsIgnoreCase(patient) &&
                        xrayApp.getDoctorName().equalsIgnoreCase(doctor)) {

                    System.out.println("Linked Appointments:");
                    System.out.println(docApp.getDetails());
                    System.out.println(xrayApp.getDetails());
                }
            }
        }

        System.out.println("All Appointments 👇 ");
        checkUpQueue.printAllAppointment();
        labTestQueue.printAllAppointment();
        xRayQueue.printAllAppointment();

        System.out.println("Upcoming Appointment -> ");
        System.out.println(checkUpQueue.nextAppointment().getDetails());

        System.out.println("Examining Patient");
        System.out.println(checkUpQueue.getExamined().getDetails());

        System.out.println("More patients to examine ? " + !checkUpQueue.isEmpty());

        System.out.println("\nUpcoming Appointment -> ");
        System.out.println(checkUpQueue.nextAppointment().getDetails());

    }
}

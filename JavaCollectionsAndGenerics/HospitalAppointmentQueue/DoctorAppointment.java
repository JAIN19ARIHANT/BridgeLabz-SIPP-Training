public class DoctorAppointment implements Appointment {
    private final String patientName;
    private final String doctorName;
    private String timeSlot;

    public DoctorAppointment(String patientName, String doctorName, String timeSlot) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.timeSlot = timeSlot;
    }

    public DoctorAppointment(String patientName, String doctorName) {
        this.patientName = patientName;
        this.doctorName = doctorName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    @Override
    public String getDetails() {
        return String.format(
                "Patient Details :\n" +
                        "  • Name         : %s\n" +
                        "  • Doctor       : %s\n" +
                        "  • Appointment  : %s\n",
                this.patientName,
                this.doctorName,
                this.timeSlot
        );
    }

}

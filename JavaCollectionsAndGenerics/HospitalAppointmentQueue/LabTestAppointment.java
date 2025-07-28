public class LabTestAppointment extends DoctorAppointment implements Appointment {
    private final String test;
    private final int cost;

    public LabTestAppointment(String patientName, String doctorName, String test, int cost) {
        super(patientName,doctorName);
        this.test = test;
        this.cost = cost;
    }

    public String getTest() {
        return test;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String getDetails() {
        return String.format(
                "Test Details :\n" +
                        "  • Name    : %s\n" +
                        "  • Test    : %s\n" +
                        "  • Ref. By : %s\n" +
                        "  • Cost    : ₹%d\n",
                getPatientName(),
                this.test,
                getDoctorName(),
                this.cost
        );
    }

}

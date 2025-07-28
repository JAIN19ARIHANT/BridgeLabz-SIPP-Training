public class XRayAppointment extends DoctorAppointment implements Appointment {
    private final String part;
    private final int costX;

    public XRayAppointment(String patientName, String doctorName, String part, int cost) {
        super(patientName,doctorName);
        this.part = part;
        this.costX = cost;
    }

    public String getPart() {
        return part;
    }

    public int getCostX() {
        return costX;
    }

    @Override
    public String getDetails() {
        return String.format(
                "X-ray Details : \n" +
                        "  • Name      : %s\n" +
                        "  • Body part : %s\n" +
                        "  • Ref. By   : %s\n" +
                        "  • Cost      : ₹%d\n",
                getPatientName(),
                this.part,
                getDoctorName(),
                this.costX
        );
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class AppointmentQueue <T extends Appointment> {
    protected Queue<T> q;

    public AppointmentQueue() {
        q = new LinkedList<>();
    }

    public void addAppointment(T appointment) {
        q.add(appointment);
    }

    public T nextAppointment() {
        return q.peek();
    }

    public T getExamined() {
        return q.poll();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public void printAllAppointment() {
        q.forEach(appointments -> System.out.println(appointments.getDetails()));
    }
}

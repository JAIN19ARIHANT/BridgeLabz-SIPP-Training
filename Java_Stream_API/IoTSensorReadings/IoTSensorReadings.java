import java.util.*;
public class IoTSensorReadings {
    public static void main(String[] args) {
        List<Integer> readings = Arrays.asList(30, 60, 80, 25, 55);
        int threshold = 50;
        System.out.println("IoT Sensor Readings above threshold (" + threshold + "):"); 
        readings.stream().filter(r -> r > threshold).forEach(r -> System.out.println("Reading: " + r));
    }
}

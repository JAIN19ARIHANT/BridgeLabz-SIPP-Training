package AgroBot;

public class Sprinkler extends IrrigationUnit implements SensorReadable {
    int radius;

    public Sprinkler (String unitId, int radius) {
        super(unitId);
        this.radius = radius;
        System.out.println("-> Sprinkler configured with a radius :" + radius + " meters.\n");
    }

    @Override
    public void startWatering() {
        System.out.println("Sprinkler " + unitId + " starts watering in area of radius : " + radius + " meters.\n");
    }

    @Override
    public void readSensorData(String sensorId) {
        System.out.println("Sprinkler " + unitId + " reads data from the sensor " + sensorId + ".\n");
    }
}

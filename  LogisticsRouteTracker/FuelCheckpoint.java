public class FuelCheckpoint extends Checkpoint {
    public FuelCheckpoint(String checkpointId, String locationName, double distanceFromLast, int expectedDuration, int actualDuration) {
        super(checkpointId, locationName, distanceFromLast, expectedDuration, actualDuration);
    }

    @Override
    public boolean isCritical() {
        return true;
    }

    @Override
    public String getType() {
        return "Fuel";
    }

    @Override
    public double calculatePenalty() {
        return isDelayed() ? 20 : 0;
    }
}

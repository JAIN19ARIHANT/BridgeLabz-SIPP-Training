public class RestCheckpoint extends Checkpoint {
    public RestCheckpoint(String checkpointId, String locationName, double distanceFromLast, int expectedDuration, int actualDuration) {
        super(checkpointId, locationName, distanceFromLast, expectedDuration, actualDuration);
    }

    @Override
    public boolean isCritical() {
        return false;
    }

    @Override
    public String getType() {
        return "Rest";
    }

    @Override
    public double calculatePenalty() {
        return (getActualDuration() - getExpectedDuration()) > 30 ? (getActualDuration() - getExpectedDuration())/2.0 : 0;
    }
}

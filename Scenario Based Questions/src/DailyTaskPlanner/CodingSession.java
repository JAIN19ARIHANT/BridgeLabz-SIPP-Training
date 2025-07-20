package DailyTaskPlanner;

public class CodingSession extends Task {
    private final int noOfCodes;

    public CodingSession (int id, String description, int noOfCodes) {
        super(id, description);
        this.noOfCodes = noOfCodes;
    }

    @Override
    public void execute() {
        System.out.println("\nCoded " + this.noOfCodes + ", coding questions in the session.");
    }

    @Override
    public String getTaskType() {
        return "Coding Session";
    }
}

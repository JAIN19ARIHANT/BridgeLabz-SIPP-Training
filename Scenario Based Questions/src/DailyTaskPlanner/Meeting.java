package DailyTaskPlanner;

public class Meeting extends Task {
    private final String time;

    public Meeting(int id, String description, String time) {
        super(id,description);
        this.time = time;
    }

    @Override
    public void execute() {
        System.out.println("\nMeeting : " + this.id + " starts from " + this.time);
    }

    @Override
    public String getTaskType() { return "Meeting"; }
}

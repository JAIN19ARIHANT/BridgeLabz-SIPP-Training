package DailyTaskPlanner;

public class Workout extends Task {
    private final int duration;

    public Workout(int id, String description, int duration) {
        super (id, description);
        this.duration = duration;
    }

    @Override
    public void execute() {
        System.out.println("\nWorkout duration : " + this.duration + " minutes.");
    }

    @Override
    public String getTaskType() { return "Workout"; }
}

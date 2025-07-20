package DailyTaskPlanner;

public abstract class Task {
    protected int id;
    protected String description;

    public Task (int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() { return this.id; }

    public String getDescription() { return this.description; }

    public abstract String getTaskType();

    public abstract void execute();

}

package DailyTaskPlanner;

import java.util.LinkedList;
import java.util.Scanner;

public class TaskPlannerMain {

    static String RESET = "\u001b[0m";
    static String RED = "\u001b[31m";
    static String BLUE = "\u001b[34m";

    public static void main(String[] args) {

        LinkedList<Task> taskList = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        int n;

        do {
            System.out.println("\n--------- TASK PLANNER ---------");
            System.out.println("1. Add a Task");
            System.out.println("2. Execute all Tasks");
            System.out.println("3. Search for a Task");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice : ");
            n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1 :
                    addTask(taskList);
                    break;

                case 2 :
                    if (taskList.isEmpty()) {
                        System.out.println(RED + "No task to execute !!" + RESET);
                        break;
                    }
                    for (Task task : taskList) {
                        task.execute();
                    }
                    break;

                case 3 :
                    if (taskList.isEmpty()) {
                        System.out.println(RED + "No task to print" + RESET);
                    }else {
                        System.out.print("Enter keyword : ");
                        String keyword = sc.nextLine().toLowerCase();
                        for (Task t : taskList) {
                            if (t.description.toLowerCase().contains(keyword))
                                System.out.println("ID : " + t.id + "\nDescription : " + t.getDescription() + "\nTask type : " + t.getTaskType());
                        }
                    }
                    break;


                case 0 :
                    System.err.println("System shutdown");
                    break;

                default:
                    System.err.println("⚠️ Wrong Input !!");
            }
        } while (n != 0);
    }

    public static void addTask (LinkedList<Task> taskArrayList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Meeting\n2.Workout\n3.Coding Session");
        int k = sc.nextInt();
        if (k == 1) {
            System.out.println(BLUE + "\nAdding a meeting task" + RESET);
            System.out.print("\nEnter Meeting ID : ");
            int meetingId = sc.nextInt();
            sc.nextLine();
            System.out.print("\nEnter Meeting description : ");
            String meetingDescription = sc.nextLine();
            System.out.print("\nMeeting Start Time : ");
            String meetingTime = sc.next();

            taskArrayList.add(new Meeting(meetingId,meetingDescription,meetingTime));
        }

        else if (k == 2) {
            System.out.println(BLUE + "\nAdding a workout task" + RESET);
            System.out.print("\nEnter workout ID : ");
            int workoutId = sc.nextInt();
            sc.nextLine();
            System.out.print("\nEnter workout description : ");
            String workoutDescription = sc.nextLine();
            System.out.print("\nworkout duration : ");
            int workoutTime = sc.nextInt();

            taskArrayList.add(new Workout(workoutId,workoutDescription,workoutTime));
        }

        else if (k == 3) {
            System.out.println(BLUE + "\nAdding a coding session task" + RESET);
            System.out.print("\nEnter coding session ID : ");
            int codingSessionId = sc.nextInt();
            sc.nextLine();
            System.out.print("\nEnter coding session description : ");
            String codingSessionDescription = sc.nextLine();
            System.out.print("\nNo. of questions solved : ");
            int questionsSolved = sc.nextInt();

            taskArrayList.add(new CodingSession(codingSessionId,codingSessionDescription, questionsSolved));
        }

        else
            System.out.println(RED + "Wrong input" + RESET);
    }
}

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class MeetingRoomScheduler {

    public static class Meeting {
        long startTime;
        long endTime;

        Meeting (long startTime, long endTime) {
            this.startTime =  startTime;
            this.endTime = endTime;
        }
    }


    public static void main(String[] args) {

        MeetingRoomScheduler scheduler = new MeetingRoomScheduler();

        Random random = new Random();

        int n = 100;

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = random.nextInt(n * 100);
        }

        for (int i = 0; i < n; i++) {
            end[i] = random.nextInt(n * 100);
        }

        System.out.println("Total number of meetings possible : " + scheduler.maxMeeting(n,start,end));



    }

    private int maxMeeting(int n, int[] start, int[] end) {
        if (n == 0)
            return 0;

        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i],end[i]);
        }

//        Arrays.sort(meetings, new Comparator<>() {
//            @Override
//            public int compare(Meeting m1, Meeting m2) {
//                return Long.compare(m1.endTime, m2.endTime);
//            }
//        });

//        Arrays.sort(meetings, (m1, m2) -> Long.compare(m1.endTime, m2.endTime));

        Arrays.sort(meetings, Comparator.comparingLong(m -> m.endTime));

        int count = 0;
        long lastEndTime = -1;

        for (int i = 0; i < n; i++) {
            if(meetings[i].startTime > lastEndTime) {
                count++;
                lastEndTime = meetings[i].endTime;
            }
        }

        return count;
    }
}

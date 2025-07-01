public class CourseHierarchy {
    public static void main(String[] args) {
        PaidOnlineCourse poc = new PaidOnlineCourse(
            "Java Programming", 6, "Udemy", true, 2999.0, 20.0
        );

        System.out.println("Course Name   : " + poc.courseName);
        System.out.println("Duration      : " + poc.duration + " weeks");
        System.out.println("Platform      : " + poc.platform);
        System.out.println("Recorded      : " + (poc.isRecorded ? "Yes" : "No"));
        System.out.println("Fee           : ₹" + poc.fee);
        System.out.println("Discount      : " + poc.discount + "%");
        System.out.println("Final Price   : ₹" + poc.getFinalFee());
    }
}

class Course {
    String courseName;
    int duration;

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
}


class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded,
                            double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double getFinalFee() {
        return fee - (fee * discount / 100);
    }
}
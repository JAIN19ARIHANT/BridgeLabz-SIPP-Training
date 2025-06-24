package JavaConstructors.Level1;

public class Circle {
    private double radius;

    public Circle() {
        this(1.0);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public static void main(String[] args) {
        System.out.println("--- Running Circle Main Method ---");

        Circle circleA = new Circle();
        System.out.println("Circle A - Initial Radius: " + circleA.getRadius());

        Circle circleB = new Circle(7.5);
        System.out.println("Circle B - Radius: " + circleB.getRadius());

        circleA.setRadius(20.0);
        System.out.println("Circle A - Updated Radius: " + circleA.getRadius());

        Circle circleC = new Circle();
        circleC.setRadius(3.14);
        System.out.println("Circle C - Radius: " + circleC.getRadius());

        System.out.println("--- End of Circle Main Method ---");
    }
}
package JavaConstructors.Level1;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {

        Person person1 = new Person("Siddhi", 9);
        System.out.println("Person 1 - Name: " + person1.getName() + ", Age: " + person1.getAge());

        Person person2 = new Person(person1);
        System.out.println("Person 2 (copy of Person 1) - Name: " + person2.getName() + ", Age: " + person2.getAge());

        person1.setAge(11);
        System.out.println("Person 1 Updated - Name: " + person1.getName() + ", Age: " + person1.getAge());
        System.out.println("Person 2 (after Person 1 update) - Name: " + person2.getName() + ", Age: " + person2.getAge());

        Person person3 = new Person("Arihant", 22);
        System.out.println("Person 3 - Name: " + person3.getName() + ", Age: " + person3.getAge());

    }
}
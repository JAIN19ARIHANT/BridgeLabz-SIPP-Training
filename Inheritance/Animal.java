public class Animal {
    public static void main(String[] args) {
        Dog spike = new Dog("Spike",8);
        spike.printDetails();
        spike.makeSound();

        Cat tom = new Cat("Tom",7);
        tom.printDetails();
        tom.makeSound();

        Bird tweety = new Bird("tweety",2);
        tweety.printDetails();
        tweety.makeSound();
    }
}

class Animals {
    String name;
    int age;

    Animals (String name, int age) {
        this.name = name;
        this.age = age;
    }

    void printDetails() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }

    void makeSound() {
        System.out.println("Animal makes sound !\n");
    }
}

class Dog extends Animals {

    Dog (String name, int age) {
        super(name,age);
    }

    @Override
    void printDetails() {
        super.printDetails();
    }

    @Override
    void makeSound() {
//        super.makeSound();                      // Animal makes sound !
        System.out.println(name + " Barks !!\n");
    }
}

class Cat extends Animals {

    Cat (String name, int age) {
        super(name,age);
    }

    @Override
    void printDetails() {
        super.printDetails();
    }

    @Override
    void makeSound(){
        System.out.println(name + " Meows !!\n");
    }
}

class Bird extends Animals{
    Bird (String name, int age) {
        super(name,age);
    }

    @Override
    void printDetails() {
        System.out.println("Name :" + name);
        System.out.println("Age : " + age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " Tweets !!\n");
    }
}
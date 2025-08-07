public class Employee {
    private String name;
    private final Email email;

    public Employee(String name, Email email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return  "\nName  : " + this.name +
                "\nEmail : " + this.email.getEmailAddress();
    }
}
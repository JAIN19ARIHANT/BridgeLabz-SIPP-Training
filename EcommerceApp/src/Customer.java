public class Customer {
    protected String custId;
    protected String name;

    Customer (String id, String name) {
        custId = id;
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

    public String getCustId() {
        return custId;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }
}

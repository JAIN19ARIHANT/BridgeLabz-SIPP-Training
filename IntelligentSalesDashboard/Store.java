import java.util.Map;
import java.util.List;

public class Store {
    private Map<String, List<Order>> customerToOrdersMap;

    public Store(Map<String, List<Order>> customerToOrdersMap) {
        this.customerToOrdersMap = customerToOrdersMap;
    }

    public Map<String, List<Order>> getCustomerToOrdersMap() {
        return customerToOrdersMap;
    }
}
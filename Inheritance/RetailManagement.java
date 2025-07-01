public class RetailManagement {
    public static void main(String[] args) {
        Order order = new Order("ORD123", "2025-06-30");
        ShippedOrder shipped = new ShippedOrder("ORD124", "2025-07-01", "TRK78945");
        DeliveredOrder delivered = new DeliveredOrder("ORD125", "2025-07-02", "TRK98765", "2025-07-04");

        System.out.println("🔹 Order Info:");
        order.displayDetails();
        System.out.println("\n🔸 Shipped Order Info:");
        shipped.displayDetails();
        System.out.println("\n✅ Delivered Order Info:");
        delivered.displayDetails();
    }
}

class Order {
    String orderId;
    String orderDate;

    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order placed on " + orderDate;
    }

    void displayDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order shipped with Tracking Number: " + trackingNumber;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Delivered on " + deliveryDate;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}
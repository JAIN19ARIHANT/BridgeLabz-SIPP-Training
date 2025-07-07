import java.util.*;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManagementSystem {
    private Item head = null;

    public void addAtBeginning(Item newItem) {
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(Item newItem) {
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addAtPosition(Item newItem, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(newItem);
            return;
        }
        Item temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeById(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        } else {
            System.out.println("Item not found.");
        }
    }

    public void updateQuantity(int id, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void search(String name, int id) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if ((id != -1 && temp.id == id) || (name != null && temp.name.equalsIgnoreCase(name))) {
                printItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found.");
    }

    public void displayItems() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        System.out.println("Inventory Items:");
        while (temp != null) {
            printItem(temp);
            temp = temp.next;
        }
    }

    public void totalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.printf("Total Inventory Value: ₹%.2f\n", total);
    }

    public void sortInventory(String by, boolean ascending) {
        head = mergeSort(head, by, ascending);
        System.out.println("Inventory sorted by " + by + " (" + (ascending ? "asc" : "desc") + ").");
    }

    private Item mergeSort(Item head, String by, boolean asc) {
        if (head == null || head.next == null) return head;
        Item middle = getMiddle(head);
        Item next = middle.next;
        middle.next = null;

        Item left = mergeSort(head, by, asc);
        Item right = mergeSort(next, by, asc);
        return merge(left, right, by, asc);
    }

    private Item merge(Item a, Item b, String by, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;
        boolean condition;
        if (by.equalsIgnoreCase("name")) {
            condition = asc ? a.name.compareToIgnoreCase(b.name) <= 0 : a.name.compareToIgnoreCase(b.name) > 0;

        } else {
            condition = asc ? a.price <= b.price : a.price > b.price;
        }

        Item result;
        if (condition) {
            result = a;
            result.next = merge(a.next, b, by, asc);
        } else {
            result = b;
            result.next = merge(a, b.next, by, asc);
        }
        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null) return null;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private void printItem(Item item) {
        System.out.println("ID: " + item.id + ", Name: " + item.name +
                ", Qty: " + item.quantity + ", Price: ₹" + item.price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryManagementSystem ims = new InventoryManagementSystem();

        while (true) {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity by ID");
            System.out.println("6. Search by ID or Name");
            System.out.println("7. Display All Items");
            System.out.println("8. Total Inventory Value");
            System.out.println("9. Sort by Name or Price");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt(); sc.nextLine();

            String name;
            int id, qty, pos;
            double price;

            switch (ch) {
                case 1: case 2: case 3:
                    System.out.print("Enter Item ID: ");
                    id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Item Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    price = sc.nextDouble();
                    Item newItem = new Item(name, id, qty, price);
                    if (ch == 1) ims.addAtBeginning(newItem);
                    else if (ch == 2) ims.addAtEnd(newItem);
                    else {
                        System.out.print("Enter Position: ");
                        pos = sc.nextInt();
                        ims.addAtPosition(newItem, pos);
                    }
                    break;

                case 4:
                    System.out.print("Enter Item ID to Remove: ");
                    id = sc.nextInt();
                    ims.removeById(id);
                    break;

                case 5:
                    System.out.print("Enter Item ID: ");
                    id = sc.nextInt();
                    System.out.print("Enter New Quantity: ");
                    qty = sc.nextInt();
                    ims.updateQuantity(id, qty);
                    break;

                case 6:
                    System.out.print("Search by ID (enter -1 to skip): ");
                    id = sc.nextInt(); sc.nextLine();
                    System.out.print("Search by Name (press Enter to skip): ");
                    name = sc.nextLine();
                    ims.search(name.isEmpty() ? null : name, id);
                    break;

                case 7:
                    ims.displayItems();
                    break;

                case 8:
                    ims.totalValue();
                    break;

                case 9:
                    System.out.print("Sort by (name/price): ");
                    String by = sc.nextLine();
                    System.out.print("Ascending? (true/false): ");
                    boolean asc = sc.nextBoolean();
                    ims.sortInventory(by, asc);
                    break;

                case 10:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


}

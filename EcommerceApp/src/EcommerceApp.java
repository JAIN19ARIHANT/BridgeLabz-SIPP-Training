import java.util.*;

public class EcommerceApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu();

        while (true) {
            System.out.println("----- 🛒 Ecommerce App Menu -----");
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Search by Name");
            System.out.println("4. Search by Category");
            System.out.println("5. Sort by Price");
            System.out.println("6. Sort by Name");
            System.out.println("7. Delete Product");
            System.out.println("8. Exit");
            System.out.println("\nChoose an Option");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 :
                    System.out.println("Enter product Id : ");
                    String id = sc.nextLine();
                    System.out.println("Enter product name : ");
                    String name = sc.nextLine();
                    System.out.println("Enter category : ");
                    String category = sc.nextLine();
                    System.out.println("Enter Price :");
                    int price = sc.nextInt();

                    menu.addProduct(new Product(id,name,price,category));
                    break;

                case 2 :
                    menu.displayAll();
                    break;

                case 3 :
                    System.out.println("Enter name of product to search : ");
                    String nameSearch = sc.nextLine();
                    List<Product> nameResults = menu.searchByName(nameSearch);
                    for (Product p : nameResults)
                        p.display();
                    break;

                case 4 :
                    System.out.println("Enter category of product to search : ");
                    String categorySearch = sc.nextLine();
                    List<Product> categoryResults = menu.searchByName(categorySearch);
                    for (Product p : categoryResults)
                        p.display();
                    break;

                case 5 :
                    System.out.println("Sorted (Price : low -> High) ");
                    List<Product> sortedPrice =  menu.sortByPrice();
                    for (Product p : sortedPrice)
                        p.display();
                    break;

                case 6 :
                    System.out.println("Sorted (Name : A -> Z) ");
                    List<Product> sortedName = menu.sortByName();
                    for (Product p : sortedName)
                        p.display();
                    break;

                case 7 :
                    System.out.println("Enter product ID to delete product : ");
                    String deleteId = sc.nextLine();
                    menu.deleteProduct(deleteId);
                    break;

                case 8 :
                    System.out.println("Thank you 🙏");
                    return;

                default :
                    System.out.println("\001B[31mWrong Input\u001B[0m");
            }
        }
    }
}

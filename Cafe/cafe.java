import java.util.Scanner;
public class cafe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to our Café ");

        double grandTotal = 0;

        int gst_rate = 18;

        boolean exit = false;

        double price_r = 49, gst_r = 0, total_r = 0;
        int qty_r = 0;
        boolean r = false;

        double price_e = 65, gst_e = 0, total_e = 0;
        int qty_e = 0;
        boolean e = false;

        double price_l = 79, gst_l = 0, total_l = 0;
        int qty_l = 0;
        boolean l = false;

        double price_c = 70, gst_c = 0, total_c = 0;
        int qty_c = 0;
        boolean c = false;

        double price_f = 100, gst_f = 0, total_f = 0;
        int qty_f = 0;
        boolean f = false;

        double price_m = 120, gst_m = 0, total_m = 0;
        int qty_m = 0;
        boolean m = false;

        while (!exit) {
            System.out.println("\nEnter coffee type (Regular, Espresso, Latte, Cappuccino, Frappe, Mocha) or Exit to stop: ");
            String coffeeType = sc.nextLine().trim();

            if (coffeeType.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.printf("Enter the quantity of %s : \n", coffeeType);
            int qty = sc.nextInt();
            sc.nextLine();


            switch (coffeeType.toLowerCase()) {

                case "regular":
                    r = true;
                    qty_r += qty;
                    gst_r = qty_r * gst_rate * price_r /100;
                    total_r = gst_r + price_r * qty_r;
                    grandTotal += total_r;
                    break;

                case "espresso":
                    e = true;
                    qty_e += qty;
                    gst_e = qty_e * gst_rate * price_e /100;
                    total_e = gst_e + price_e * qty_e;
                    grandTotal += total_e;
                    break;

                case "latte":
                    l = true;
                    qty_l += qty;
                    gst_l = qty_l * gst_rate * price_l /100;
                    total_l = gst_l + price_l * qty_l;
                    grandTotal += total_l;
                    break;

                case "cappuccino":
                    c = true;
                    qty_c += qty;
                    gst_c = qty_c * gst_rate * price_c /100;
                    total_c = gst_c + price_c * qty_c;
                    grandTotal += total_c;
                    break;

                case "frappe":
                    f = true;
                    qty_f += qty;
                    gst_f = qty_f * gst_rate * price_f /100;
                    total_f = gst_f + price_f * qty_f;
                    grandTotal += total_f;
                    break;

                case "mocha":
                    m = true;
                    qty_m += qty;
                    gst_m = qty_m * gst_rate * price_m /100;
                    total_m = gst_m + price_m * qty_m;
                    grandTotal += total_m;
                    break;

                case "exit": {
                    exit = true;
                    break;
                }

                default:
                    System.out.println("Wrong input !! \n Please select a coffee from the menu.");

            }
        }


        System.out.println("\n----------------- INVOICE -----------------");

        System.out.println("Coffee \t\t Qty \t Price \t GST \t Total");

        if (r)
            System.out.println("Regular \t " + qty_r + "\t\t " + price_r *  qty_r + "\t " + gst_r + "\t " + total_r);
        if (e)
            System.out.println("Espresso \t " + qty_e + "\t\t " + price_e * qty_e + "\t " + gst_e + "\t " + total_e);
        if (l)
            System.out.println("Latte \t\t " + qty_l + "\t\t " + price_l * qty_l + "\t " + gst_l + "\t " + total_l);
        if (c)
            System.out.println("Cappuccino \t " + qty_c + "\t\t " + price_c * qty_c + "\t " + gst_c + "\t " + total_c);
        if (f)
            System.out.println("Frappe \t\t " + qty_f + "\t\t " + price_f * qty_f + "\t " + gst_f + "\t " + total_f);
        if (m)
            System.out.println("Mocha \t\t " + qty_m + "\t\t " + price_m * qty_m + "\t " + gst_m + "\t " + total_m);

        System.out.println("-------------------------------------------");
        System.out.println("Grand Total: \t\t\t\t\t\t₹" + grandTotal);

    }
}
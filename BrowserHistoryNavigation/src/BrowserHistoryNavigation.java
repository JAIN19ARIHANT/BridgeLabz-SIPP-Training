import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BrowserHistoryNavigation {
    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory();

        List<String> fullHistory = new ArrayList<>();

        bh.visit("https://www.google.com");
        fullHistory.add(bh.getCurrentPage().substring(9));

        bh.visit("https://www.youtube.com");
        fullHistory.add(bh.getCurrentPage().substring(9));

        bh.visit("https://www.bridgelabz.com");
        fullHistory.add(bh.getCurrentPage().substring(9));

        bh.visit("https://www.leetcode.com");
        fullHistory.add(bh.getCurrentPage().substring(9));

        bh.visit("https://www.twitter.com");
        fullHistory.add(bh.getCurrentPage().substring(9));

        bh.visit("https://www.grok.com");
        fullHistory.add(bh.getCurrentPage().substring(9));

        bh.visit("https://www.forbes.com/consent/ketch/?toURL=https://www.forbes.com/real-time-billionaires/");
        fullHistory.add(bh.getCurrentPage().substring(9));

        System.out.println("\n\n");

        System.out.println(bh.getCurrentPage());

        while (true) {
            System.out.println("\n---------------------------------------");
            System.out.println("\n------------Browser History------------");
            System.out.println("1. Visit a website");
            System.out.println("2. <- Previous Page");
            System.out.println("3. Next Page ->");
            System.out.println("4. Current Page");
            System.out.println("5. View full history");
            System.out.println("6. Clear Browser history");
            System.out.println("7. EXIT\n");

            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1 :
                    System.out.println("Enter the website url you want to visit : ");
                    String url = sc.nextLine();
                    bh.visit(url);
                    fullHistory.add(bh.getCurrentPage().substring(9));
                    break;

                case 2:
                    bh.goBackward();
                    break;

                case 3 :
                    bh.goForward();
                    break;

                case 4 :
                    System.out.println(bh.getCurrentPage());
                    break;

                case 5 :
                    for (String str : fullHistory)
                        System.out.println(str);
                    break;

                case 6 :
                    bh.clearHistory();
                    System.out.println("History cleared!\nNothing to display");
                    break;

                case 7 :
                    System.exit(0);
                    break;

                default:
                    System.out.println("Wrong input ‼️");
                    break;
            }
        }
    }
}

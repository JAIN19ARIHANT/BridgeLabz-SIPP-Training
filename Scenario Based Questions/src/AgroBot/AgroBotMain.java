package AgroBot;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AgroBotMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Agro Bot");
        Scanner sc = new Scanner(System.in);

        ArrayList<IrrigationUnit> units = new ArrayList<>();

        while (true) {
            System.out.println("1. Add a Sprinkler");
            System.out.println("2. Add a Drip System");
            System.out.println("3. Start watering");
            System.out.println("4. Run diagnostics");
            System.out.println("5. Read sprinkler's sensor data");
            System.out.println("6. Exit");

            int n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1 :
                    System.out.print("\nEnter the radius of Sprinkler : ");
                    int radius = sc.nextInt();
                    System.out.print("\nEnter sprinkler id : ");
                    String sId = sc.next();
                    units.add(new Sprinkler(sId,radius));
                    break;

                case 2 :
                    System.out.print("\nEnter the flow rate of Drip System : ");
                    double flowrate = sc.nextDouble();
                    System.out.print("\nEnter drip system id : ");
                    String dsId = sc.next();
                    units.add(new DripSystem(dsId,flowrate));
                    break;

                case 3:
                    if (units.isEmpty()) {
                        System.err.println("\n❌ No irrigation units added. Cannot start watering.\n");
                    } else {
                        System.out.println("\n✅ Watering started for " + units.size() + " units.\n");
                        for (IrrigationUnit unit : units) {
                            unit.startWatering();
                        }
                    }
                    break;

                case 4 :
                    if (units.isEmpty()) {
                        System.err.println("\n❌ No irrigation units added. Please add a Sprinkler or Drip System first.\n");
                    } else {
                        for (IrrigationUnit unit : units) {
                            unit.runDiagnostics();
                        }
                    }
                    break;


                case 5 :
                    boolean sprinklerFound = false;
                    String sensorId = "SPR-" + new Random().nextInt(1000);
                    for (IrrigationUnit unit : units) {
                        if (unit instanceof Sprinkler) {
                            sprinklerFound = true;
                            ((Sprinkler) unit).readSensorData(sensorId);
                        }
                    }
                    if (!sprinklerFound) {
                        System.err.println("\nNo sprinkler units found. Sensor data cannot be read.\n");
                    }
                    break;

                case 6 :
                    System.err.println("\nAgro Bot System shutting down !\n");
                    System.exit(0);

                default:
                    System.err.println("\nWrong input!!\n");
            }
        }
    }
}

interface Bookable {
    void bookRoom();
}

abstract class Room implements Bookable{
    String guestName;
    int roomNo;
    String roomType;

    Room(String guestName, int roomNo, String roomType) {
        this.guestName = guestName;
        this.roomNo = roomNo;
        this.roomType = roomType;
    }

    public abstract int calculatePrice(int nights);

}

class DeluxeRoom extends Room {
    private final int priceDeluxe = 4000;
    int nights;

    DeluxeRoom(String guestName, int roomNo) {
        super(guestName,roomNo,"Deluxe");
    }

    @Override
    public int calculatePrice(int nights) {
        this.nights = nights;
        return nights * priceDeluxe;
    }

    @Override
    public void bookRoom() {
        System.out.println("Guest: " + guestName);
        System.out.println("Room Type: " + roomType + " | Room No: " + roomNo);
        System.out.println("Nights Booked: " + nights);
        System.out.println("Total Bill: ₹" + calculatePrice(nights));
        System.out.println("----------------------------------");
    }
}

class SuiteRoom extends Room {
    private final int priceSuite = 3000;
    int nights;

    SuiteRoom(String guestName, int roomNo) {
        super(guestName,roomNo,"Suite");
    }

    @Override
    public int calculatePrice(int nights) {
        this.nights = nights;
        return nights * priceSuite;
    }

    @Override
    public void bookRoom() {
        System.out.println("Guest: " + guestName);
        System.out.println("Room Type: " + roomType + " | Room No: " + roomNo);
        System.out.println("Nights Booked: " + nights);
        System.out.println("Total Bill: ₹" + calculatePrice(nights));
        System.out.println("----------------------------------");
    }
}

class StandardRoom extends Room {
    private final int priceStandard = 1500;
    int nights;

    StandardRoom(String guestName, int roomNo) {
        super(guestName,roomNo,"Standard");
    }

    @Override
    public int calculatePrice(int nights) {
        this.nights = nights;
        return nights * priceStandard;
    }

    @Override
    public void bookRoom() {
        System.out.println("Guest: " + guestName);
        System.out.println("Room Type: " + roomType + " | Room No: " + roomNo);
        System.out.println("Nights Booked: " + nights);
        System.out.println("Total Bill: ₹" + calculatePrice(nights));
        System.out.println("----------------------------------");
    }
}

public class HotelRoomBookingSystem {
    public static void main(String[] args) {
        DeluxeRoom d1 = new DeluxeRoom("Arihant Jain",1008);
        SuiteRoom s1 = new SuiteRoom("Suryansh",2085);
        StandardRoom sd1 = new StandardRoom("Arjun",147);

        d1.calculatePrice(4);
        d1.bookRoom();

        s1.calculatePrice(3);
        s1.bookRoom();

        sd1.calculatePrice(5);
        sd1.bookRoom();
    }
}
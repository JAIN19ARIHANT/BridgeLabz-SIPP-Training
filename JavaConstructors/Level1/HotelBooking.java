package JavaConstructors.Level1;

public class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    public HotelBooking() {
        this.guestName = "Guest";
        this.roomType = "Standard";
        this.nights = 1;
    }

    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public static void main(String[] args) {

        HotelBooking booking1 = new HotelBooking();
        System.out.println("Booking 1 (Default) - Guest: " + booking1.getGuestName() + ", Room Type: " + booking1.getRoomType() + ", Nights: " + booking1.getNights());

        HotelBooking booking2 = new HotelBooking("Alice Wonderland", "Deluxe", 3);
        System.out.println("Booking 2 (Custom) - Guest: " + booking2.getGuestName() + ", Room Type: " + booking2.getRoomType() + ", Nights: " + booking2.getNights());

        HotelBooking booking3 = new HotelBooking(booking2);
        System.out.println("Booking 3 (Copy of Booking 2) - Guest: " + booking3.getGuestName() + ", Room Type: " + booking3.getRoomType() + ", Nights: " + booking3.getNights());

        booking1.setGuestName("Bob The Builder");
        booking1.setNights(5);
        System.out.println("Booking 1 (Updated) - Guest: " + booking1.getGuestName() + ", Room Type: " + booking1.getRoomType() + ", Nights: " + booking1.getNights());

    }
}
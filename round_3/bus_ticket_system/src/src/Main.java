import app.BusTicketBookingApp;

public class Main {
    public static void main(String[] args) {
        try {
            BusTicketBookingApp app = new BusTicketBookingApp();
            app.start();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}

package helper;

import model.Bus;
import model.Ticket;

import java.time.format.DateTimeFormatter;

/**
 * Formats and prints ticket details. Extracted here because the same
 * display logic was previously duplicated in both CustomerService and
 * TicketService.
 */
public final class TicketPrinter {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy | hh:mm a");

    private TicketPrinter() {
        // prevent instantiation
    }

    public static void print(Ticket ticket) {
        if (ticket == null) {
            return;
        }
        System.out.println("=================================================================");
        System.out.println("Ticket ID          : " + ticket.getTicketId());
        System.out.println("Booked Date & Time : " + ticket.getBookedDate().format(FORMAT));
        System.out.println("Customer           : " + ticket.getCusBooked().getName());
        System.out.println("Bus                : " + ticket.getBusBooked().getBusName());
        System.out.println("Passengers         : " + ticket.getPassengerCount());
        System.out.println("Seats              : " + ticket.getSeatBookedNo());
        System.out.printf("Total Fare         : %.2f%n", ticket.getTotalFare());
        System.out.println("=================================================================");
    }

    public static void seatLayout(Bus bus) {
        System.out.println("============================");
        System.out.println("Bus: " + bus.getBusName());
        System.out.println("============================");

        for (int i = 1; i <= bus.getSeat().getTotalSeat(); i++) {
            System.out.print(bus.getSeat().getSeatBookedStatus(i) ? i + "[B] " : i + "[A] ");
            if (i % 6 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n============================");
        System.out.println("A = Available");
        System.out.println("B = Booked");
        System.out.println("============================");
    }

    public static void customerBookingSummary(String cusName, int tick,int pass,int fare){
        System.out.println("===============================");
        System.out.println("Customer: "+ cusName);
        System.out.println("Tickets: "+ tick);
        System.out.println("Passengers: " + pass);
        System.out.println("Total Fare: " + fare);

    }


}

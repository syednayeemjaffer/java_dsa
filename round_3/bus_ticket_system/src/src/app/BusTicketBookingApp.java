package app;

import helper.ScannerHelper;
import service.BusService;
import service.CustomerService;
import service.TicketService;

public class BusTicketBookingApp {
    private final ScannerHelper s = new ScannerHelper();
    private final BusService busService = new BusService();
    private final CustomerService cusService = new CustomerService();
    private final TicketService ticketService = new TicketService();

    public void start() {
        while (true) {
            System.out.println("\n========== WELCOME ==========");
            System.out.println("1. Bus Service");
            System.out.println("2. Customer Service");
            System.out.println("3. Ticket booking Service ");
            System.out.println("4. Exit");

            int choice = s.intValue("Enter your choice: ");
            switch (choice) {
                case 1:
                    busService.busService();
                    break;
                case 2:
                    cusService.customerService();
                    break;
                case 3:
                    cusService.customerService();
                    break;
                case 4:
                    ticketService.ticketService();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

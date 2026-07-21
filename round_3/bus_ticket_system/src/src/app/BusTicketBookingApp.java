package app;

import database.BusDatabase;
import database.CustomerDatabase;
import database.TicketDatabase;
import enums.Gender;
import helper.IDGenerator;
import helper.ScannerHelper;
import model.Bus;
import model.Customer;
import service.BusService;
import service.CustomerService;
import service.TicketService;

public class BusTicketBookingApp {
    private final ScannerHelper s = new ScannerHelper();

    // Single shared database instances, injected into every service that needs them.
    private final BusDatabase busDatabase = new BusDatabase();
    private final CustomerDatabase customerDatabase = new CustomerDatabase();
    private final TicketDatabase ticketDatabase = new TicketDatabase();

    private final BusService busService = new BusService(busDatabase);
    private final CustomerService cusService = new CustomerService(customerDatabase, ticketDatabase);
    private final TicketService ticketService = new TicketService(ticketDatabase, customerDatabase, busDatabase);

    public BusTicketBookingApp() {
        seedData();
    }

    private void seedData() {
        busDatabase.addBus(new Bus(IDGenerator.generateID(), "TN01", "Express", "Madurai", "Chennai", 500, 40));
        busDatabase.addBus(new Bus(IDGenerator.generateID(), "TN02", "Bava Travels", "Madurai", "Ooty", 300, 50));

        customerDatabase.addCustomer(new Customer(IDGenerator.generateID(), "Syed", Gender.MALE, 22, 9344242496L, "syed@gmail.com"));
        customerDatabase.addCustomer(new Customer(IDGenerator.generateID(), "Nasreen", Gender.FEMALE, 21, 9344242497L, "nasreen@gmail.com"));
    }

    public void start() {
        while (true) {
            System.out.println("\n========== WELCOME ==========");
            System.out.println("1. Bus Service");
            System.out.println("2. Customer Service");
            System.out.println("3. Ticket Booking Service");
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
                    ticketService.ticketService();
                    break;
                case 4:
                    System.out.println("Thank you for using Bus Ticket Booking System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

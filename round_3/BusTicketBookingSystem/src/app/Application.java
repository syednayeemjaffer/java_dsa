package app;

import model.*;
import service.BookingService;
import service.BusService;
import service.CustomerService;
import util.IDGenerator;

import java.util.List;
import java.util.Scanner;

public class Application {

    private final Scanner scanner;
    private final BusService busService;
    private final CustomerService customerService;
    private final BookingService bookingService;

    public Application() {
        scanner = new Scanner(System.in);
        busService = new BusService();
        customerService = new CustomerService();
        bookingService = new BookingService();
    }

    public void start() {
        while (true) {
            showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    customerMenu();
                    break;
                case 3:
                    System.out.println("\nThank you for using our application.");
                    return;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    private void showMainMenu() {
        System.out.println();
        System.out.println("==================================");
        System.out.println(" BUS TICKET BOOKING SYSTEM ");
        System.out.println("==================================");
        System.out.println("1. Admin");
        System.out.println("2. Customer");
        System.out.println("3. Exit");
        System.out.print("Enter Choice : ");
    }

    private void adminMenu() {
        while (true) {
            System.out.println();
            System.out.println("======= ADMIN MENU =======");
            System.out.println("1. View All Buses");
            System.out.println("2. Search Bus");
            System.out.println("3. Add Bus");
            System.out.println("4. Update Bus Fare");
            System.out.println("5. Delete Bus");
            System.out.println("6. Back");
            System.out.print("Enter Choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    displayAllBuses();
                    break;
                case 2:
                    searchBus();
                    break;
                case 3:
                    addBus();
                    break;
                case 4:
                    updateFare();
                    break;
                case 5:
                    deleteBus();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    private void customerMenu() {
        while (true) {
            System.out.println();
            System.out.println("======= CUSTOMER MENU =======");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Back");
            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerCustomer();
                    break;
                case 2:
                    loginCustomer();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
    private void addBus() {
        System.out.println();
        System.out.print("Bus ID : ");
        int busId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Bus Number : ");
        String busNumber = scanner.nextLine();
        System.out.print("Bus Name : ");
        String busName = scanner.nextLine();
        System.out.print("Source : ");
        String source = scanner.nextLine();
        System.out.print("Destination : ");
        String destination = scanner.nextLine();
        System.out.print("Departure Time : ");
        String departure = scanner.nextLine();
        System.out.print("Arrival Time : ");
        String arrival = scanner.nextLine();
        System.out.print("Total Seats : ");
        int totalSeats = scanner.nextInt();
        System.out.print("Available Seats : ");
        int availableSeats = scanner.nextInt();
        System.out.print("Fare : ");
        double fare = scanner.nextDouble();
        scanner.nextLine();
        boolean success = busService.addBus(new Bus(
                busId, busNumber, busName, source, destination,
                departure, arrival, totalSeats, availableSeats, fare));
        System.out.println(success ? "Bus Added Successfully." : "Unable to Add Bus.");
    }

    private void searchBus() {
        System.out.print("Enter Bus ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Bus bus = busService.searchBus(id);
        if (bus == null) {
            System.out.println("Bus Not Found.");
            return;
        }
        System.out.println(bus);
        System.out.println();
        bus.displaySeats();
    }

    private void bookTicket(Customer customer) {
        System.out.println("\n========== BOOK TICKET ==========");

        displayAllBuses();

        System.out.print("\nEnter Bus ID : ");
        int busId = scanner.nextInt();
        scanner.nextLine();

        Bus bus = busService.searchBus(busId);

        if (bus == null) {
            System.out.println("Bus Not Found.");
            return;
        }

        selectSeat(customer, bus);
    }

    private void selectSeat(Customer customer, Bus bus) {
        System.out.println("\n========== AVAILABLE SEATS ==========");
        bus.displaySeats();

        System.out.print("\nEnter Seat Number : ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine();

        Seat seat = bus.getSeat(seatNumber);

        if (seat == null) {
            System.out.println("Invalid Seat Number.");
            return;
        }

        if (seat.isBooked()) {
            System.out.println("Seat Already Booked.");
            return;
        }

        enterPassengerDetails(customer, bus, seat);
    }

    private void enterPassengerDetails(Customer customer, Bus bus, Seat seat) {
        System.out.println("\n========== PASSENGER DETAILS ==========");

        System.out.print("Passenger Name : ");
        String passengerName = scanner.nextLine();

        System.out.print("Passenger Age : ");
        int passengerAge = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Passenger Gender : ");
        String passengerGender = scanner.nextLine();

        System.out.print("Phone Number : ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Email : ");
        String email = scanner.nextLine();

        Passenger passenger = new Passenger(
                passengerName,
                passengerAge,
                passengerGender,
                phoneNumber,
                email,
                null
        );

        if (!bus.bookSeat(seat.getSeatNumber())) {
            System.out.println("Seat Booking Failed.");
            return;
        }

        Ticket ticket = new Ticket(
                IDGenerator.generateTicketId(),
                customer,
                passenger,
                bus,
                seat,
                bus.getFare()
        );

        bookingService.bookTicket(ticket);

        System.out.println();
        System.out.println("================================");
        System.out.println("BOOKING SUCCESSFUL");
        System.out.println("================================");
        System.out.println(ticket);
    }

    private void displayAllBuses() {
        List<Bus> buses = busService.getAllBuses();
        if (buses.isEmpty()) {
            System.out.println("No buses available.");
            return;
        }
        for (Bus bus : buses) {
            System.out.println(bus);
        }
    }

    private void updateFare() {
        System.out.print("Enter Bus ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Fare : ");
        double fare = scanner.nextDouble();
        scanner.nextLine();
        System.out.println(busService.updateFare(id, fare)
                ? "Fare Updated Successfully." : "Bus Not Found.");
    }

    private void deleteBus() {
        System.out.print("Enter Bus ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println(busService.deleteBus(id)
                ? "Bus Deleted Successfully." : "Bus Not Found.");
    }

    private void registerCustomer() {
        System.out.println("\n===== CUSTOMER REGISTRATION =====");

        System.out.print("User ID : ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name : ");
        String name = scanner.nextLine();

        System.out.print("Phone Number : ");
        String phone = scanner.nextLine();

        System.out.print("Email : ");
        String email = scanner.nextLine();

        System.out.print("Username : ");
        String username = scanner.nextLine();

        System.out.print("Password : ");
        String password = scanner.nextLine();

        Customer customer = new Customer(
                userId,
                name,
                phone,
                email,
                username,
                password
        );

        if (customerService.register(customer)) {
            System.out.println("Registration Successful.");
        } else {
            System.out.println("Username already exists.");
        }
    }

    private void loginCustomer() {
        System.out.println("\n===== CUSTOMER LOGIN =====");

        System.out.print("Username : ");
        String username = scanner.nextLine();

        System.out.print("Password : ");
        String password = scanner.nextLine();

        Customer customer = customerService.login(username, password);

        if (customer == null) {
            System.out.println("Invalid Username or Password.");
            return;
        }

        customerDashboard(customer);
    }
    private void customerDashboard(Customer customer) {
        while (true) {
            System.out.println();
            System.out.println("===== CUSTOMER DASHBOARD =====");
            System.out.println("Welcome " + customer.getName());
            System.out.println("1. View Profile");
            System.out.println("2. View All Buses");
            System.out.println("3. Search Bus");
            System.out.println("4. Book Ticket");
            System.out.println("5. View My Bookings");
            System.out.println("6. Cancel Ticket");
            System.out.println("7. Logout");
            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println(customer);
                    break;
                case 2:
                    displayAllBuses();
                    break;
                case 3:
                    searchBus();
                    break;
                case 4:
                    bookTicket(customer);
                    break;
                case 5:
                    viewMyBookings(customer);
                    break;
                case 6:
                    cancelTicket(customer);
                    break;
                case 7:
                    return;
            }
        }
    }

    private void viewMyBookings(Customer customer) {
        List<Ticket> tickets = bookingService.getTicketsByCustomer(customer);

        if (tickets.isEmpty()) {
            System.out.println("No Bookings Found.");
            return;
        }

        System.out.println("\n========== MY BOOKINGS ==========");

        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }

    private void cancelTicket(Customer customer) {
        System.out.print("Enter Ticket ID : ");
        int ticketId = scanner.nextInt();
        scanner.nextLine();

        Ticket ticket = bookingService.searchTicket(ticketId);

        if (ticket == null) {
            System.out.println("Ticket Not Found.");
            return;
        }

        if (ticket.getCustomer().getUserId() != customer.getUserId()) {
            System.out.println("You are not allowed to cancel this ticket.");
            return;
        }

        ticket.getBus().cancelSeat(ticket.getSeat().getSeatNumber());
        bookingService.cancelTicket(ticketId);
        System.out.println("Ticket Cancelled Successfully.");
    }
}
package app;

import enums.Gender;
import exception.BusNotFoundException;
import exception.InvalidAgeException;
import exception.InvalidSeatException;
import model.Bus;
import model.Customer;
import model.Ticket;
import repository.BookingRepository;
import repository.BusRepository;
import repository.CustomerRepository;
import service.BookingService;
import service.BusService;
import service.CustomerService;
import util.InputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Application {
    private final BusService busService;
    private final CustomerService customerService;
    private final BookingService bookingService;

    public Application() {
        BusRepository busRepository = new BusRepository();
        CustomerRepository customerRepository = new CustomerRepository();
        BookingRepository bookingRepository = new BookingRepository();

        busService = new BusService(busRepository);
        customerService = new CustomerService(customerRepository);
        bookingService = new BookingService(bookingRepository, busRepository);

        // Seed a few buses for demo
        seedData();
    }

    private void seedData() {
        try {
            busService.addBus("TN01-AB-1234", "Chennai", "Bangalore",
                    java.time.LocalDateTime.now().plusDays(1).withHour(8).withMinute(0), 40, 500);
            busService.addBus("KA02-CD-5678", "Bangalore", "Chennai",
                    java.time.LocalDateTime.now().plusDays(1).withHour(22).withMinute(30), 40, 450);
            busService.addBus("MH03-EF-9012", "Mumbai", "Pune",
                    java.time.LocalDateTime.now().plusDays(2).withHour(6).withMinute(15), 30, 350);
        } catch (Exception e) {
            System.out.println("Seeding error: " + e.getMessage());
        }
    }

    public void start() {
        System.out.println("=== BUS TICKET BOOKING SYSTEM ===");
        while (true) {
            System.out.println("\n1. Admin: Add Bus");
            System.out.println("2. User: Register Customer");
            System.out.println("3. User: Search Buses");
            System.out.println("4. User: Book Ticket");
            System.out.println("5. User: My Bookings");
            System.out.println("6. User: Cancel Ticket");
            System.out.println("7. Exit");
            int choice = InputUtil.readInt("Choose an option: ");

            switch (choice) {
                case 1: adminAddBus(); break;
                case 2: registerCustomer(); break;
                case 3: searchBuses(); break;
                case 4: bookTicket(); break;
                case 5: myBookings(); break;
                case 6: cancelTicket(); break;
                case 7:
                    System.out.println("Thank you for using the system.");
                    InputUtil.closeScanner();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void adminAddBus() {
        System.out.println("\n--- Add New Bus ---");
        String busNumber = InputUtil.readString("Bus Number: ");
        String source = InputUtil.readString("Source: ");
        String destination = InputUtil.readString("Destination: ");
        java.time.LocalDateTime departure = InputUtil.readLocalDateTime("Departure date & time");
        int totalSeats = InputUtil.readInt("Total seats: ");
        double fare = InputUtil.readDouble("Fare per seat: ");
        Bus bus = busService.addBus(busNumber, source, destination, departure, totalSeats, fare);
        System.out.println("Bus added successfully: " + bus);
    }

    private String getOrCreateCustomer() {
        String input = InputUtil.readString("Enter your Customer ID (or type 'NEW' to register): ");
        if ("NEW".equalsIgnoreCase(input.trim())) {
            return registerCustomer();
        }
        Optional<Customer> cust = customerService.findCustomerById(input.trim());
        if (cust.isPresent()) {
            System.out.println("Welcome back, " + cust.get().getName() + "!");
            return cust.get().getId();
        } else {
            System.out.println("Customer not found. Please register first.");
            return registerCustomer();
        }
    }

    private String registerCustomer() {
        System.out.println("\n--- Customer Registration ---");
        String name = InputUtil.readString("Name: ");
        String phone = InputUtil.readString("Phone: ");
        String email = InputUtil.readString("Email: ");
        String street = InputUtil.readString("Street: ");
        String city = InputUtil.readString("City: ");
        String zip = InputUtil.readString("ZIP: ");
        Customer customer = customerService.registerCustomer(name, phone, email, street, city, zip);
        System.out.println("Registration successful. Your ID: " + customer.getId());
        return customer.getId();
    }

    private void searchBuses() {
        System.out.println("\n--- Search Buses ---");
        String source = InputUtil.readString("Source: ");
        String destination = InputUtil.readString("Destination: ");
        List<Bus> buses = busService.searchBuses(source, destination);
        if (buses.isEmpty()) {
            System.out.println("No buses found for this route.");
        } else {
            System.out.println("Available buses:");
            buses.forEach(System.out::println);
        }
    }

    private void bookTicket() {
        System.out.println("\n--- Book Ticket ---");
        String customerId = getOrCreateCustomer();
        String busId = InputUtil.readString("Enter Bus ID: ");
        try {
            Bus bus = busService.getBusById(busId);
            System.out.println("Selected Bus: " + bus);
            int passengersCount = InputUtil.readInt("Number of passengers: ");

            List<String> names = new ArrayList<>();
            List<Integer> ages = new ArrayList<>();
            List<Gender> genders = new ArrayList<>();

            for (int i = 0; i < passengersCount; i++) {
                System.out.println("Passenger " + (i + 1) + ":");
                String name = InputUtil.readString("Name: ");
                int age = InputUtil.readInt("Age: ");
                String genderStr = InputUtil.readString("Gender (MALE/FEMALE/OTHER): ").toUpperCase();
                Gender gender;
                try {
                    gender = Gender.valueOf(genderStr);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid gender, defaulting to OTHER.");
                    gender = Gender.OTHER;
                }
                names.add(name);
                ages.add(age);
                genders.add(gender);
            }

            Ticket ticket = bookingService.bookTicket(customerId, busId, names, ages, genders);
            System.out.println("\nBooking successful!");
            System.out.println(ticket);
        } catch (BusNotFoundException | InvalidAgeException | InvalidSeatException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }

    private void myBookings() {
        System.out.println("\n--- My Bookings ---");
        String customerId = InputUtil.readString("Enter your Customer ID: ");
        List<Ticket> tickets = bookingService.getBookingsByCustomer(customerId);
        if (tickets.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            tickets.forEach(t -> System.out.println(t.getTicketId() + " | Bus: " +
                    t.getBusId() + " | Status: " + t.getStatus() + " | Fare: " + t.getTotalFare()));
        }
    }

    private void cancelTicket() {
        System.out.println("\n--- Cancel Ticket ---");
        String ticketId = InputUtil.readString("Enter Ticket ID: ");
        try {
            Ticket cancelled = bookingService.cancelTicket(ticketId);
            System.out.println("Ticket cancelled successfully.");
            System.out.println("Refund amount: ₹" + cancelled.getTotalFare());
        } catch (Exception e) {
            System.out.println("Cancellation failed: " + e.getMessage());
        }
    }
}
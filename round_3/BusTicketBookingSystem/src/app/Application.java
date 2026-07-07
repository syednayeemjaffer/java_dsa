package app;

import service.BusService;

import java.util.Scanner;

public class Application {

    private final Scanner scanner;
    private final BusService busService;

    public Application() {
        scanner = new Scanner(System.in);
        busService = new BusService();
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
            System.out.println("========== ADMIN MENU ==========");
            System.out.println("1. Add Bus");
            System.out.println("2. View All Buses");
            System.out.println("3. Delete Bus");
            System.out.println("4. Back");
            System.out.print("Enter Choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addBus();
                    break;
                case 2:
                    busService.displayAllBuses();
                    break;
                case 3:
                    System.out.print("Enter Bus ID : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    busService.deleteBus(id);
                    break;
                case 4:
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
            System.out.println("1. View All Buses");
            System.out.println("2. Search Bus");
            System.out.println("3. Back");
            System.out.print("Enter Choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    busService.displayAllBuses();
                    break;
                case 2:
                    searchBus();
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
        busService.addBus(new model.Bus(
                busId,
                busNumber,
                busName,
                source,
                destination,
                departure,
                arrival,
                totalSeats,
                availableSeats,
                fare
        ));
    }

    private void searchBus() {
        System.out.print("Enter Bus ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        var bus = busService.searchBus(id);
        if (bus == null) {
            System.out.println("Bus Not Found.");
        } else {
            System.out.println(bus);
        }
    }
}
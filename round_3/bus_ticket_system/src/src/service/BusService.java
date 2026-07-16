package service;

import database.BusDatabase;
import helper.IDGenerator;
import helper.ScannerHelper;
import model.Bus;

import java.util.List;

public class BusService {
    private final ScannerHelper s = new ScannerHelper();
    private final BusDatabase busDatabase = new BusDatabase();

    public BusService() {
        // Seed data
        busDatabase.addBus(new Bus(IDGenerator.generateID(), "TN01", "Express", "Madurai", "Chennai", 500, 40));
        busDatabase.addBus(new Bus(IDGenerator.generateID(), "TN02", "Bava Travels", "Madurai", "Ooty", 300, 50));
    }

    public void busService() {
        while (true) {
            System.out.println("\n========== BUS TICKET BOOKING ==========");
            System.out.println("1. View All Buses");
            System.out.println("2. Search Bus by ID");
            System.out.println("3. Search Bus by Route");
            System.out.println("4. Back");

            int choice = s.intValue("Enter your choice: ");
            switch (choice) {
                case 1:
                    viewAllBuses();
                    break;
                case 2:
                    searchBus();
                    break;
                case 3:
                    searchByRoute();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewAllBuses() {
        List<Bus> buses = busDatabase.getBusDB();

        if (buses.isEmpty()) {
            System.out.println("No buses available.");
            return;
        }

        System.out.println("Total buses: " + Bus.getTotalBus());
        printHeader();
        for (Bus bus : buses) {
            printBusRow(bus);
        }
    }

    private void searchBus() {
        String id = s.stringValue("Enter Bus ID: ");
        Bus bus = busDatabase.getById(id);

        if (bus == null) {
            System.out.println("Bus not found. Please enter a valid Bus ID.");
            return;
        }

        printBusDetails(bus);
    }

    private void searchByRoute() {
        String source = s.stringValue("Source: ");
        String destination = s.stringValue("Destination: ");

        List<Bus> buses = busDatabase.getBusByRoute(source, destination);
        if (buses.isEmpty()) {
            System.out.println("No bus available for this route.");
            return;
        }

        for (Bus bus : buses) {
            printBusDetails(bus);
        }
    }

    private void printHeader() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-8s %-10s %-15s %-12s %-15s %-8s %-6s%n",
                "ID", "Bus No", "Name", "Source", "Destination", "Fare", "Seats");
        System.out.println("----------------------------------------------------------------------------");
    }

    private void printBusRow(Bus bus) {
        System.out.printf("%-8s %-10s %-15s %-12s %-15s %-8.2f %-6d%n",
                bus.getId(),
                bus.getBusNo(),
                bus.getBusName(),
                bus.getSource(),
                bus.getDestination(),
                bus.getFare(),
                bus.getSeat());
    }

    private void printBusDetails(Bus bus) {
        System.out.println("\n========== BUS DETAILS ==========");
        System.out.println("Bus ID      : " + bus.getId());
        System.out.println("Bus Number  : " + bus.getBusNo());
        System.out.println("Bus Name    : " + bus.getBusName());
        System.out.println("Source      : " + bus.getSource());
        System.out.println("Destination : " + bus.getDestination());
        System.out.println("Fare        : " + bus.getFare());
        System.out.println("Seats       : " + bus.getSeat());
    }
}

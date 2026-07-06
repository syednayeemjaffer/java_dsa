package main;

import model.Bus;
import service.BusService;

public class Main {

    public static void main(String[] args) {

        BusService busService = new BusService();

        Bus bus1 = new Bus(
                1,
                "TN01AB1234",
                "Nayeem Travels",
                "Chennai",
                "Bangalore",
                "09:30 PM",
                "05:45 AM",
                40,
                40,
                1200
        );

        Bus bus2 = new Bus(
                2,
                "TN10XY5678",
                "Orange Travels",
                "Madurai",
                "Coimbatore",
                "10:00 PM",
                "04:30 AM",
                36,
                36,
                950
        );

        busService.addBus(bus1);
        busService.addBus(bus2);

        System.out.println("\n===== ALL BUSES =====");
        busService.displayAllBuses();

        System.out.println("\n===== SEARCH BUS =====");
        Bus foundBus = busService.searchBus(2);

        if (foundBus != null) {
            System.out.println(foundBus);
        } else {
            System.out.println("Bus not found.");
        }

        System.out.println("\n===== DELETE BUS =====");
        busService.deleteBus(1);

        System.out.println("\n===== ALL BUSES AFTER DELETE =====");
        busService.displayAllBuses();

    }

}
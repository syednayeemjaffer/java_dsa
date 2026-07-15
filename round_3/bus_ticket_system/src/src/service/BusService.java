package service;

import database.BusDatabase;
import helper.IDGenerator;
import model.Bus;

import java.util.List;
import java.util.Scanner;

public class BusService {
    Scanner s = new Scanner(System.in);
    public Bus bus1 = new Bus(IDGenerator.generateID(),"TN01","Express","madurai","chennai",500,40);
    public Bus bus2 = new Bus(IDGenerator.generateID(),"TN02","bava","madurai","ooty",300,50);
    private static BusDatabase busDatabase = new BusDatabase();

    public void busService(){
        busDatabase.addBus(bus1);
        busDatabase.addBus(bus2);
        while (true){
            System.out.println("========== BUS TICKET BOOKING ==========");
            System.out.println("1. View All Buses");
            System.out.println("2. Search Bus by ID");
            System.out.println("3. Search Bus by Route");
            System.out.println("4. Exit");


            int choice;
            choice = s.nextInt();
            s.nextLine();
            switch (choice){
                case 1:
                    viewAllBuses();
                    break;
                case 2:
                    searchBus();
                    break;
                case 3:
                    searchByRoot();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;

            }
        }

    }

    // Service function
    public void viewAllBuses(){
        System.out.println("Total bus: " + bus1.getTotalBus());
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-6s %-10s %-15s %-12s %-15s %-8s %-10s%n",
                "ID", "Bus No", "Name", "Source", "Destination", "Fare","Seat");
        System.out.println("----------------------------------------------------------------------------");

        List<Bus> buses = busDatabase.getBusDB();

        for (Bus bus : buses) {
            System.out.printf("%-6s %-10s %-15s %-12s %-15s %-8.2f %-4d%n",
                    bus.getId(),
                    bus.getBusNo(),
                    bus.getBusName(),
                    bus.getSource(),
                    bus.getDestination(),
                    bus.getFare(),
                    bus.getSeat()
            );
        }
    }

    public void searchBus() {
        System.out.print("Enter Bus ID : ");
        String id = s.nextLine();

        Bus bus = busDatabase.getById(id);

        if (bus == null) {
            System.out.println("Bus not found. Please enter a valid Bus ID.");
            return; // Stop the method here
        }

        System.out.println("\n========== BUS DETAILS ==========");
        System.out.println("Bus Number  : " + bus.getBusNo());
        System.out.println("Bus Name    : " + bus.getBusName());
        System.out.println("Source      : " + bus.getSource());
        System.out.println("Destination : " + bus.getDestination());
        System.out.println("Fare        : " + bus.getFare());
        System.out.println("Seats       : " + bus.getSeat());
        System.out.println();
    }

    public void searchByRoot(){
        System.out.print("Source: ");
        String sour = s.nextLine();
        System.out.print("Destination: ");
        String dest = s.nextLine();

        System.out.println("///////"+sour + "////"+dest);
        List<Bus> buses = busDatabase.getBusByRoute(sour,dest);
        if (buses.size() == 0){
            System.out.println("Now bus us available for this root. \n");
        }
        for (Bus bus:buses){
            System.out.println("\n========== BUS DETAILS ==========");
            System.out.println("Bus Number  : " + bus.getBusNo());
            System.out.println("Bus Name    : " + bus.getBusName());
            System.out.println("Source      : " + bus.getSource());
            System.out.println("Destination : " + bus.getDestination());
            System.out.println("Fare        : " + bus.getFare());
            System.out.println("Seats       : " + bus.getSeat() + "\n");
        }

    }
}

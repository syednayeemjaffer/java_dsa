package app;

import database.BusDatabase;
import model.Bus;

import java.util.List;
import java.util.Scanner;

public class BusTicketBookingApp {
    public Bus bus1 = new Bus(1,"TN01","Express","Madurai","Chennai",500,40);
    public Bus bus2 = new Bus(2,"TN02","bava","Madurai","ooty",300,50);
    public BusDatabase busDatabase = new BusDatabase();
    Scanner s = new Scanner(System.in);

    public  void start(){
        busDatabase.addBus(bus1);
        busDatabase.addBus(bus2);
        while (true){
            System.out.println("========== BUS TICKET BOOKING ==========\n");
            System.out.println("1. View All Buses\n");
            System.out.println("2. Search Bus by ID\n");
            System.out.println("3. Search Bus by Route\n");
            System.out.println("4. Exit");

            int choice;
            choice = s.nextInt();
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

    //view all buses
    public void viewAllBuses(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-4s %-10s %-15s %-12s %-15s %-8s %-10s%n",
                "ID", "Bus No", "Name", "Source", "Destination", "Fare","Seat");
        System.out.println("----------------------------------------------------------------------------");

        List<Bus> buses = busDatabase.getBusDB();

        for (Bus bus : buses) {
            System.out.printf("%-4d %-10s %-15s %-12s %-15s %-8.2f %-4d%n",
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
        int id = s.nextInt();

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
    }

    public void searchByRoot(String sour, String dest){
        Bus bus = busDatabase.getBusByRoot(sour,dest);

    }
}

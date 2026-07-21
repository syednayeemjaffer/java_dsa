package service;

import database.BusDatabase;
import database.CustomerDatabase;
import database.TicketDatabase;
import helper.ScannerHelper;
import model.Bus;
import model.Ticket;

import java.util.List;

public class ReportService {
    ScannerHelper s = new ScannerHelper();
    TicketDatabase tickDB ;
    BusDatabase busDB ;
    CustomerDatabase cusDB;

    public ReportService(TicketDatabase tickDB , BusDatabase busDB,CustomerDatabase cusDB){
        this.tickDB = tickDB;
        this.busDB = busDB;
        this.cusDB = cusDB;
    }

    public void reportService(){
        while (true){
            System.out.println("=========== REPORTS ===========");
            System.out.println("1. Dashboard");
            System.out.println("2. Most Booked Bus");
            System.out.println("3. Least Booked Bus");
            System.out.println("4. Highest Paying Customer");
            System.out.println("5. Daily Revenue");
            System.out.println("6. Route Revenue");
            System.out.println("7. Bus Revenue");
            System.out.println("8. Seat Occupancy Report");
            System.out.println("9. Customer History");
            System.out.println("10. Revenue Leaderboard");
            System.out.println("11. Back");

            int choice = s.intValue("Enter your choice: ");

            switch (choice) {
                case 1:
                    dashBoard();
                    break;
                case 2:
                    mostBookedBus();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }

    public void dashBoard(){
        System.out.println("==============================");
        System.out.println("SYSTEM DASHBOARD ");
        System.out.println("==============================");

        System.out.println("Total Buses        : " + busDB.getBusDB().size());
        System.out.println("Total Customers    : "+ cusDB.getCusDB().size());
        System.out.println("Total Tickets      : "+ tickDB.getTickDB().size());
        int passengerCount = tickDB.getTickDB()
                        .stream().mapToInt(ticket -> ticket.getPassengerCount()).sum();
        int availableSeat = busDB.getBusDB()
                        .stream().mapToInt(bus -> bus.getSeat().getTotalSeat()).sum();
        int bookedSeat = availableSeat - busDB.getBusDB()
                        .stream().mapToInt(bus -> bus.getSeat().getAvailableSeat()).sum();
        double totalRevenue = busDB.getBusDB()
                        .stream().mapToDouble(bus -> bus.getTotalTicket()
                        .stream().mapToDouble(ticket -> ticket.getTotalFare()).sum()).sum();
        System.out.println("Total Passengers   : "+ passengerCount);
        System.out.println("Available Seats    : "+ availableSeat);
        System.out.println("Booked Seats       : "+ bookedSeat);
        System.out.println("Total Revenue      : "+ totalRevenue);
    }

    public void mostBookedBus(){
        List<Bus> buslist = busDB.getBusDB();
        Bus selectedBus = buslist.get(0);
        for (Bus bus: buslist){
            if (bus.getSeat().getAvailableSeat() < selectedBus.getSeat().getAvailableSeat()){
                selectedBus = bus;
            }
        }
        
        System.out.println("Most Booked Bus: "+);
    }
}

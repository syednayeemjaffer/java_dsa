package service;

import database.BusDatabase;
import database.CustomerDatabase;
import database.TicketDatabase;
import enums.Gender;
import helper.IDGenerator;
import helper.ScannerHelper;
import model.Bus;
import model.Customer;
import model.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public class TicketService {
    private final ScannerHelper s = new ScannerHelper();
    private final TicketDatabase tickDB = new TicketDatabase();
    private final CustomerDatabase cusDB = new CustomerDatabase();
    private final BusDatabase busDB = new BusDatabase();
    private Customer cus;

    public TicketService(){
        Customer cus = new Customer(IDGenerator.generateID(), "Syed", Gender.MALE, 22, 9344242496L, "syed@gmail.com");
        Bus bus = new Bus(IDGenerator.generateID(), "TN01", "Express", "Madurai", "Chennai", 500, 40);
        tickDB.addTicket(new Ticket(IDGenerator.generateID(),cus,bus,2,500));
    }
    public void ticketService(){
        String cusID = s.stringValue("Plz enter customer id: ");
        cus = cusDB.getById(cusID);
        if(cus != null){
            while (true){
                System.out.println("\n=========== CUSTOMER MANAGEMENT ===========");
                System.out.println("1. Book Ticket");

                int choice = s.intValue("");
                switch (choice){
                    case 1:
                        bookTicket();
                        break;
                    case 2:
                        System.out.println("Thankyou for comming into booking service");
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        }else {
            System.out.println("Plz registor first to book the ticket.");
        }


    }

    private void bookTicket(){
        String source;
        String destination;
        List<Bus> buses;
        while (true){
             source = s.stringValue("Enter teh source: ");
             destination = s.stringValue("Enter the destination: ");
            if(!source.isEmpty() || !destination.isEmpty()){
                break;
            }
            System.out.println("Source or destination is empty,Plz enter");
        }

        while (true){
            buses = busDB.getBusByRoute(source,destination);
            if(buses.size() != 0){
                break;
            };
            System.out.println("Buses are not available for this root,Plz select different root");
        }
        System.out.println("Available buses:");
        printHeader();
        for (int i = 0;i<buses.size();i++){
            System.out.print("No. "+ i+1);
            printBusRow(buses.get(i));
        }
        int selectNo;
        while (true){
            selectNo = s.intValue("Enter bus No. to book: ")-1;
            if(buses.size() > selectNo){
                break;
            }
            System.out.println("Enter the valid No.");
        }
        Bus busSelected =buses.get(selectNo);
        seatLayout(busSelected);

        int passengerCount [] = new int[s.intValue("Enter the passengerCount: ")];
        for (int i = 0;i<passengerCount.length;i++){
            while (true){
                if(!busSelected.getSeat().getSeatBookedStatus(passengerCount[i])){
                    break;
                }
                System.out.println("This seat is already booked,Plz select Available seats");
            }
        }
        int totalFare = (int) busSelected.getFare() * passengerCount.length;
        Ticket tick = new Ticket(IDGenerator.generateID(),cus,busSelected,passengerCount.length,totalFare);
        tickDB.addTicket(tick);
        displayTicket(tick);

    }
    private void printHeader() {
        System.out.println("=============================================");
        System.out.printf("%-8s %-8s %-10s %-8s %-5s %-12s %-20d %-12d %-12d%n",
                "No.","Id", "busNo", "BusName", "Source", "Destination", "Fare","TotalSeats","SeatsAvailable");
        System.out.println("=============================================");
    }
    private void printBusRow(Bus bus) {
        System.out.printf("%-8s %-10s %-8s %-5d %-12d %-20s %-12d %-12d%n",
                bus.getId(),
                bus.getBusNo(),
                bus.getBusName(),
                bus.getSource(),
                bus.getDestination(),
                bus.getFare(),
                bus.getSeat().getTotalSeat(),
                bus.getSeat().getAvailableSeat()
        );
    }
    private void seatLayout(Bus bus){
        System.out.println(
                "============================\n" +
                "Bus :"+ bus.getBusName()+"\n"+
                "============================");

        for (int i = 1;i<=bus.getSeat().getTotalSeat();i++){
            if (!bus.getSeat().getSeatBookedStatus(i)){
                System.out.print(i+1 + " [A]");
            }else {
                System.out.print(i+1 + " [B]");
            }
            if(i % 6 == 0){
                System.out.print("\n");
            }
        }
        System.out.println("============================\n" +
                "A = Available\n" +
                "B = Booked \n"+
                "============================");
    }
    public void displayTicket(Ticket tick){
        System.out.println("====================================\n" +
                "Ticket Booked Successfully\n" +
                "====================================");
        System.out.println(
                "Ticket ID : "+tick.getTicketId() + "\n" +
                "Customer :\n"+tick.getCusBooked().getName() + "\n" +
                "Bus :\n"+tick.getBusBooked().getBusName() + "\n" +
                "Passengers :\n"+tick.getPassengerCount() + "\n" +
                "Seats :\n"+
                "Total Fare :\n"
                );
    }
}

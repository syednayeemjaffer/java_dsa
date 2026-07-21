package service;

import database.BusDatabase;
import database.CustomerDatabase;
import database.TicketDatabase;
import helper.IDGenerator;
import helper.ScannerHelper;
import helper.TicketPrinter;
import model.Bus;
import model.Customer;
import model.Ticket;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private final ScannerHelper s = new ScannerHelper();
    private final TicketDatabase tickDB;
    private final CustomerDatabase cusDB;
    private final BusDatabase busDB;

    public TicketService(TicketDatabase tickDB, CustomerDatabase cusDB, BusDatabase busDB) {
        this.tickDB = tickDB;
        this.cusDB = cusDB;
        this.busDB = busDB;
    }

    public void ticketService() {
        String cusId = s.stringValue("Please enter customer ID: ");
        Customer cus = cusDB.getById(cusId);

        if (cus == null) {
            System.out.println("Customer not found. Please register first to book a ticket.");
            return;
        }

        while (true) {
            System.out.println("\n=========== TICKET BOOKING ===========");
            System.out.println("1. Book Ticket");
            System.out.println("2. View All Tickets Booked");
            System.out.println("3. Get ticket by ID");
            System.out.println("4. Get ticket by Bus");
            System.out.println("5. Search Ticket by Date");
            System.out.println("6. Delete Ticket Booked");
            System.out.println("7. View Seat Layout");
            System.out.println("8. Bus Occupancy");
            System.out.println("9. Customer Booking Summary");
            System.out.println("10. Bus Booking Summary");
            System.out.println("11. Back");

            int choice = s.intValue("Enter your choice: ");
            switch (choice) {
                case 1:
                    bookTicket(cus);
                    break;
                case 2:
                    viewAllTicket();
                    break;
                case 3:
                    viewTicketById(cus);
                    break;
                case 4:
                    searchTickByBus(cus);
                    break;
                case 5:
                    searchTickByDate(cus);
                    break;
                case 6:
                    deleteTicket(cus);
                    break;
                case 7:
                    getBusSeatLayout();
                    break;
                case 8:
                    viewBusOccupence();
                    break;
               case 9:
                    viewCustomerSummary(cus);
                    break;
                case 10:
                    busBookingSummary();
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void bookTicket(Customer cus) {
        List<Bus> buses;
        while (true) {
            String source = s.stringValue("Enter the source: ");
            String destination = s.stringValue("Enter the destination: ");

            if (source.isEmpty() || destination.isEmpty()) {
                System.out.println("Source or destination cannot be empty.");
                continue;
            }

            buses = busDB.getBusByRoute(source, destination);
            if (!buses.isEmpty()) {
                break;
            }
            System.out.println("No buses available for this route. Please try a different route.");
        }

        System.out.println("Available buses:");
        printHeader();
        for (int i = 0; i < buses.size(); i++) {
            printBusRow(buses.get(i), i + 1);
        }

        int selectedIndex;
        while (true) {
            selectedIndex = s.intValue("Enter bus No to book: ") - 1;
            if (selectedIndex >= 0 && selectedIndex < buses.size()) {
                break;
            }
            System.out.println("Please enter a valid bus number from the list.");
        }
        Bus busSelected = buses.get(selectedIndex);

        TicketPrinter.seatLayout(busSelected);

        if (busSelected.getSeat().getAvailableSeat() == 0) {
            System.out.println("This bus has no available seats.");
            return;
        }

        int passengerCount;
        while (true) {
            passengerCount = s.intValue("Enter the passenger count: ");
            if (passengerCount > 0 && passengerCount <= busSelected.getSeat().getAvailableSeat()) {
                break;
            }
            System.out.println("Please enter a number between 1 and " + busSelected.getSeat().getAvailableSeat() + ".");
        }

        List<Integer> bookedSeatNo = new ArrayList<>();
        for (int i = 0; i < passengerCount; i++) {
            while (true) {
                int seatNo = s.intValue("Enter seat No for passenger " + (i + 1) + ": ");
                if (!busSelected.getSeat().isValidSeatNo(seatNo)) {
                    System.out.println("Invalid seat number. Please choose between 1 and " + busSelected.getSeat().getTotalSeat() + ".");
                    continue;
                }
                if (busSelected.getSeat().getSeatBookedStatus(seatNo)) {
                    System.out.println("This seat is already booked. Please select an available seat.");
                    continue;
                }
                busSelected.getSeat().seatBooking(cus, seatNo);
                bookedSeatNo.add(seatNo);
                break;
            }
        }

        double totalFare = busSelected.getFare() * passengerCount;
        Ticket ticket = new Ticket(IDGenerator.generateID(), cus, busSelected, bookedSeatNo, passengerCount, totalFare);
        busSelected.addTicket(ticket);

        System.out.println("\nTicket booked successfully!");
        TicketPrinter.print(ticket);
    }

    private void viewAllTicket() {
        List<Ticket> allTickets = tickDB.getTickDB();

        if (allTickets.isEmpty()) {
            System.out.println("No tickets have been booked yet.");
            return;
        }

        for (Ticket ticket : allTickets) {
            TicketPrinter.print(ticket);
        }
    }

    private void deleteTicket(Customer cus) {
        List<Ticket> ticketsBooked = tickDB.getByCusId(cus.getId());

        if (ticketsBooked.isEmpty()) {
            System.out.println("No tickets found for this customer.");
            return;
        }

        for (Ticket ticket : ticketsBooked) {
            TicketPrinter.print(ticket);
        }

        String ticketId = s.stringValue("Enter the ticket ID to delete: ");
        Ticket ticketToDelete = tickDB.getById(ticketId);

        if (ticketToDelete == null || !ticketToDelete.getCusBooked().getId().equals(cus.getId())) {
            System.out.println("Ticket not found for this customer.");
            return;
        }

        for (int seatNo : ticketToDelete.getSeatBookedNoRaw()) {
            if (!ticketToDelete.getBusBooked().getSeat().seatDelete(cus, seatNo)) {
                System.out.println("Warning: could not free seat " + seatNo + ".");
            }
        }

        if (tickDB.deleteTicketById(ticketId)) {
            System.out.println("Ticket deleted successfully.");
        } else {
            System.out.println("Error occurred while deleting the ticket.");
        }
    }

    private void viewTicketById(Customer cus){
        List<Ticket> tickList = tickDB.getByCusId(cus.getId());
        String tickID = s.stringValue("Enter ticket ID: ");
        Ticket selectedTick = null;
        for (Ticket tick : tickList){
            if(tick.getTicketId().equals(tickID)){
                selectedTick = tick;
            }
        }
        if (selectedTick == null){
            System.out.println("Invalid ID plz select the crt id");
            return;
        }
        TicketPrinter.print(selectedTick);
    }

    private void searchTickByDate(Customer cus){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String input = s.stringValue("Please enter the date (dd-MM-yyyy): ");
        LocalDate date = LocalDate.parse(input, formatter);

        List<Ticket> tick = tickDB.getTicketByDate(date);
        if (tick.size() == 0){
            System.out.println("Not ticket it booked at this Data");
            return;
        }
        for (Ticket ticket : tick){
            if(ticket.getCusBooked() == cus)
                TicketPrinter.print(ticket);
        }
    }

    private void getBusSeatLayout(){
        String busID = s.stringValue("Enter bus ID: ");
        Bus bus = busDB.getById(busID);
        if (bus == null){
            System.out.println("Enter the crt bus ID");
            return;
        }

        TicketPrinter.seatLayout(bus);
    }

    private void searchTickByBus(Customer cus){
        Bus busSelected;
        while (true){
            String busId = s.stringValue("Enter bus ID: ");
            busSelected  = busDB.getById(busId);
            if(busSelected != null){
                break;
            }
            System.out.println("Plz enter the valid bus ID");
        }
        List<Ticket> ticks = tickDB.getByCusId(cus.getId());
        if(ticks.size() > 0){
            for (Ticket tick : ticks){
                TicketPrinter.print(tick);
            }
        }else {
            System.out.println("No tick is booked by this customer in this bus !");
        }
    }

    private void viewBusOccupence(){
        Bus busSelected;
        String busID;

        while (true){
            busID = s.stringValue("Enter bus ID: ");
            busSelected = busDB.getById(busID);
            if(busSelected != null){
                break;
            }
            System.out.println("Bus is not found by this id");
        }
        int seat = busSelected.getSeat().getTotalSeat();
        int avai = busSelected.getSeat().getAvailableSeat();
        System.out.println("Total Seats: "+ seat);
        System.out.println("Booked Seats: "+ (seat - avai) );
        System.out.println("Available Seats: "+ busSelected.getSeat().getAvailableSeat());
        int booked = seat - avai;
        double occupancy = ((double) booked / seat) * 100;
        System.out.println("Occupancy: " + occupancy);
    }


    private void viewCustomerSummary(Customer cus){
        List<Ticket> allTick = tickDB.getByCusId(cus.getId());
        if (allTick.size() == 0){
            System.out.println("No ticket is booked by this customer");
            return;
        }
        int passCount = 0,totalFare = 0;
        for (Ticket tick: allTick){
            passCount += tick.getPassengerCount();
            totalFare += tick.getTotalFare();
        }
        TicketPrinter.customerBookingSummary(cus.getName(),allTick.size(),passCount,totalFare);
    }

    private void busBookingSummary() {
        String busID = s.stringValue("Enter the bus ID: ");
        Bus busSelected = busDB.getById(busID);

        System.out.println("Bus name: " + busSelected.getBusName());
        System.out.println("Total Tickets: " + busSelected.getTotalTicket().size());
        System.out.println("Passengers: " + (busSelected.getSeat().getTotalSeat() - busSelected.getSeat().getAvailableSeat()));
        List<Ticket> ticks = busSelected.getTotalTicket();
        int tickFare =0;
        for (Ticket tick : ticks){
            tickFare += tick.getTotalFare();
        }
        System.out.println("Revenue: " +  tickFare);

    }
    // Helper methods
    private void printHeader() {
        System.out.println("=======================================================================================================");
        System.out.printf("%-5s %-10s %-10s %-15s %-12s %-15s %-8s %-10s %-10s%n",
                "No.", "ID", "Bus No", "Bus Name", "Source", "Destination", "Fare", "Seats", "Available");
        System.out.println("=======================================================================================================");
    }

    private void printBusRow(Bus bus, int index) {
        System.out.printf("%-5d %-10s %-10s %-15s %-12s %-15s %-8.2f %-10d %-10d%n",
                index,
                bus.getId(),
                bus.getBusNo(),
                bus.getBusName(),
                bus.getSource(),
                bus.getDestination(),
                bus.getFare(),
                bus.getSeat().getTotalSeat(),
                bus.getSeat().getAvailableSeat());
    }

    private void printBusDetails(Bus bus) {
        System.out.println("\n========== BUS DETAILS ==========");
        System.out.println("Bus ID          : " + bus.getId());
        System.out.println("Bus Number      : " + bus.getBusNo());
        System.out.println("Bus Name        : " + bus.getBusName());
        System.out.println("Source          : " + bus.getSource());
        System.out.println("Destination     : " + bus.getDestination());
        System.out.println("Fare            : " + bus.getFare());
        System.out.println("Total Seats     : " + bus.getSeat().getTotalSeat());
        System.out.println("Available Seats : " + bus.getSeat().getAvailableSeat());
    }


}

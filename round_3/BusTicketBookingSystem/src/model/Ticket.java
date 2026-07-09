package model;

public class Ticket {

    private int ticketId;
    private Passenger passenger;
    private Bus bus;
    private Seat seat;
    private double fare;
    private Customer customer;

    public Ticket(int ticketId, Customer customer, Passenger passenger, Bus bus, Seat seat, double fare){
        this.ticketId = ticketId;
        this.customer = customer;
        this.passenger = passenger;
        this.bus = bus;
        this.seat = seat;
        this.fare = fare;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Bus getBus() {
        return bus;
    }

    public Seat getSeat() {
        return seat;
    }

    public double getFare() {
        return fare;
    }
    public Customer getCustomer() {
        return customer;
    }
    @Override
    public String toString() {
        return "==============================\n" +
                "Ticket ID      : " + ticketId + "\n" +
                "Passenger Name : " + passenger.getName() + "\n" +
                "Bus Name       : " + bus.getBusName() + "\n" +
                "Source         : " + bus.getSource() + "\n" +
                "Destination    : " + bus.getDestination() + "\n" +
                "Seat Number    : " + seat.getSeatNumber() + "\n" +
                "Fare           : ₹" + fare + "\n" +
                "==============================";
    }
}
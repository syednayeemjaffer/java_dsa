package model;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    private final String id;
    private final String busNo;
    private final String busName;
    private final String source;
    private final String destination;
    private final double fare;
    private final Seat seat;
    private final List<Ticket> totalTicket;
    private static int totalBus;

    public Bus(String id, String busNo, String busName, String source, String destination, double fare, int seat) {
        this.id = id;
        this.busNo = busNo;
        this.busName = busName;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
        this.seat = new Seat(seat);
        this.totalTicket = new ArrayList<>();
        totalBus++;
    }

    public String getId() {
        return id;
    }

    public String getBusNo() {
        return busNo;
    }

    public String getBusName() {
        return busName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getFare() {
        return fare;
    }

    public Seat getSeat() {
        return seat;
    }

    public static int getTotalBus() {
        return totalBus;
    }

    public List<Ticket> getTotalTicket() {
        return totalTicket;
    }

    public boolean addTicket(Ticket tick){
        totalTicket.add(tick);
        return true;
    }
    @Override
    public String toString() {
        return "Bus{" +
                "id='" + id + '\'' +
                ", busNo='" + busNo + '\'' +
                ", busName='" + busName + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", fare=" + fare +
                ", totalSeats=" + seat.getTotalSeat() +
                ", availableSeats=" + seat.getAvailableSeat() +
                '}';
    }
}

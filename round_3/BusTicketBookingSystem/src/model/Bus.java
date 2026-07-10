package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bus {
    private final String id;
    private String busNumber;
    private String source;
    private String destination;
    private LocalDateTime departureDateTime;
    private int totalSeats;
    private double farePerSeat;
    private List<Seat> seats;

    public Bus(String id, String busNumber, String source, String destination,
               LocalDateTime departureDateTime, int totalSeats, double farePerSeat) {
        this.id = id;
        this.busNumber = busNumber;
        this.source = source;
        this.destination = destination;
        this.departureDateTime = departureDateTime;
        this.totalSeats = totalSeats;
        this.farePerSeat = farePerSeat;
        this.seats = new ArrayList<>();
        for (int i = 1; i <= totalSeats; i++) {
            seats.add(new Seat(i));
        }
    }

    public String getId() { return id; }
    public String getBusNumber() { return busNumber; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public LocalDateTime getDepartureDateTime() { return departureDateTime; }
    public int getTotalSeats() { return totalSeats; }
    public double getFarePerSeat() { return farePerSeat; }
    public List<Seat> getSeats() { return seats; }

    public List<Seat> getAvailableSeats() {
        return seats.stream()
                .filter(seat -> !seat.isBooked())
                .collect(Collectors.toList());
    }

    public int getAvailableSeatCount() {
        return (int) seats.stream().filter(seat -> !seat.isBooked()).count();
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Bus No: %s | %s → %s | Departure: %s | Fare: ₹%.2f | Available: %d/%d",
                id, busNumber, source, destination, departureDateTime, farePerSeat,
                getAvailableSeatCount(), totalSeats);
    }
}
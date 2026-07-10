package model;

import java.time.LocalDateTime;
import java.util.List;

public class Ticket {
    public enum Status { CONFIRMED, CANCELLED }

    private final String ticketId;
    private final String customerId;
    private final String busId;
    private List<Passenger> passengers;
    private LocalDateTime bookingDateTime;
    private double totalFare;
    private Status status;

    public Ticket(String ticketId, String customerId, String busId,
                  List<Passenger> passengers, double totalFare) {
        this.ticketId = ticketId;
        this.customerId = customerId;
        this.busId = busId;
        this.passengers = passengers;
        this.bookingDateTime = LocalDateTime.now();
        this.totalFare = totalFare;
        this.status = Status.CONFIRMED;
    }

    public String getTicketId() { return ticketId; }
    public String getCustomerId() { return customerId; }
    public String getBusId() { return busId; }
    public List<Passenger> getPassengers() { return passengers; }
    public LocalDateTime getBookingDateTime() { return bookingDateTime; }
    public double getTotalFare() { return totalFare; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════╗\n");
        sb.append(String.format("║  TICKET ID : %-25s ║\n", ticketId));
        sb.append(String.format("║  BUS ID    : %-25s ║\n", busId));
        sb.append(String.format("║  STATUS    : %-25s ║\n", status));
        sb.append(String.format("║  FARE      : ₹%-24.2f ║\n", totalFare));
        sb.append(String.format("║  DATE      : %-25s ║\n", bookingDateTime));
        sb.append("╠════════════════════════════════════════╣\n");
        sb.append("║  PASSENGERS                           ║\n");
        for (Passenger p : passengers) {
            sb.append(String.format("║  %-36s ║\n", p.toString()));
        }
        sb.append("╚════════════════════════════════════════╝");
        return sb.toString();
    }
}
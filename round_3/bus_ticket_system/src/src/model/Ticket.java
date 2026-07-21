package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private final String ticketId;
    private final Customer cusBooked;
    private final Bus busBooked;
    private final LocalDateTime bookedDate;
    private final List<Integer> bookedSeatNo;
    private final int passengerCount;
    private final double totalFare;

    public Ticket(String ticketId, Customer cusBooked, Bus busBooked, List<Integer> bookedSeatNo,
                  int passengerCount, double totalFare) {
        this.ticketId = ticketId;
        this.cusBooked = cusBooked;
        this.busBooked = busBooked;
        this.bookedDate = LocalDateTime.now();
        this.bookedSeatNo = new ArrayList<>(bookedSeatNo);
        this.passengerCount = passengerCount;
        this.totalFare = totalFare;
    }

    public String getTicketId() {
        return ticketId;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public LocalDateTime getBookedDate() {
        return bookedDate;
    }

    public Bus getBusBooked() {
        return busBooked;
    }

    public Customer getCusBooked() {
        return cusBooked;
    }

    public String getSeatBookedNo() {
        return bookedSeatNo.toString();
    }

    public List<Integer> getSeatBookedNoRaw() {
        return new ArrayList<>(bookedSeatNo);
    }
}

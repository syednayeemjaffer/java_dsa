package model;

import java.time.LocalDateTime;

public class Ticket {
    private final String ticketId;
    private final Customer cusBooked;
    private final Bus busBooked;
    private final LocalDateTime bookedDate;
    private final int passengerCount;
    private final int totalFare;

    public Ticket(String ticketId, Customer cusBooked, Bus busBooked, LocalDateTime bookedDate, int passengerCount, int totalFare) {
        this.ticketId = ticketId;
        this.cusBooked = cusBooked;
        this.busBooked = busBooked;
        this.bookedDate = bookedDate;
        this.passengerCount = passengerCount;
        this.totalFare = totalFare;
    }

    public String getTicketId() {
        return ticketId;
    }

    public int getTotalFare() {
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
}

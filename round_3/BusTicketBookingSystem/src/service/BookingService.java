package service;

import enums.Gender;
import exception.BusNotFoundException;
import exception.InvalidAgeException;
import exception.InvalidSeatException;
import model.*;
import repository.BookingRepository;
import repository.BusRepository;
import util.IDGenerator;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private final BookingRepository bookingRepository;
    private final BusRepository busRepository;

    public BookingService(BookingRepository bookingRepository, BusRepository busRepository) {
        this.bookingRepository = bookingRepository;
        this.busRepository = busRepository;
    }

    public Ticket bookTicket(String customerId, String busId, List<String> passengerNames,
                             List<Integer> passengerAges, List<Gender> passengerGenders) {
        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new BusNotFoundException("Bus not found with ID: " + busId));

        int passengerCount = passengerNames.size();
        List<Seat> availableSeats = bus.getAvailableSeats();
        if (availableSeats.size() < passengerCount) {
            throw new InvalidSeatException("Not enough seats available. Required: " +
                    passengerCount + ", Available: " + availableSeats.size());
        }

        // Validate ages
        for (int age : passengerAges) {
            if (age <= 0 || age > 120) {
                throw new InvalidAgeException("Invalid age: " + age + ". Age must be between 1 and 120.");
            }
        }

        // Auto-allocate first available seats sequentially
        List<Passenger> passengers = new ArrayList<>();
        for (int i = 0; i < passengerCount; i++) {
            Seat seat = availableSeats.get(i);
            seat.setBooked(true);
            Passenger passenger = new Passenger(
                    passengerNames.get(i),
                    passengerAges.get(i),
                    passengerGenders.get(i),
                    seat.getSeatNumber()
            );
            passengers.add(passenger);
        }

        double totalFare = passengerCount * bus.getFarePerSeat();
        String ticketId = IDGenerator.generateTicketId();
        Ticket ticket = new Ticket(ticketId, customerId, busId, passengers, totalFare);
        bookingRepository.save(ticket);
        return ticket;
    }

    public Ticket cancelTicket(String ticketId) {
        Ticket ticket = bookingRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found: " + ticketId));
        if (ticket.getStatus() == Ticket.Status.CANCELLED) {
            throw new IllegalStateException("Ticket is already cancelled.");
        }
        // Free the seats
        Bus bus = busRepository.findById(ticket.getBusId())
                .orElseThrow(() -> new BusNotFoundException("Associated bus not found."));
        for (Passenger p : ticket.getPassengers()) {
            bus.getSeats().stream()
                    .filter(seat -> seat.getSeatNumber() == p.getSeatNumber())
                    .findFirst()
                    .ifPresent(seat -> seat.setBooked(false));
        }
        ticket.setStatus(Ticket.Status.CANCELLED);
        return ticket;
    }

    public List<Ticket> getBookingsByCustomer(String customerId) {
        return bookingRepository.findByCustomerId(customerId);
    }

    public List<Ticket> getAllTickets() {
        return bookingRepository.findAll();
    }
}
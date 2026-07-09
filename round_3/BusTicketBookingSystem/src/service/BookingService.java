package service;

import model.Customer;
import model.Ticket;
import repository.BookingRepository;

import java.util.List;

public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService() {
        bookingRepository = new BookingRepository();
    }

    public void bookTicket(Ticket ticket) {
        bookingRepository.addTicket(ticket);
    }

    public List<Ticket> getAllTickets() {
        return bookingRepository.getAllTickets();
    }

    public Ticket searchTicket(int ticketId) {
        return bookingRepository.findTicket(ticketId);
    }

    public boolean cancelTicket(int ticketId) {
        return bookingRepository.removeTicket(ticketId);
    }

    public List<Ticket> getTicketsByCustomer(Customer customer) {
        return bookingRepository.getTicketsByCustomer(customer);
    }
}
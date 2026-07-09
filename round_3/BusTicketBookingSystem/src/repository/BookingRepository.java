package repository;

import model.Customer;
import model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class BookingRepository {

    private final List<Ticket> tickets;

    public BookingRepository() {
        tickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getAllTickets() {
        return new ArrayList<>(tickets);
    }

    public Ticket findTicket(int ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == ticketId) {
                return ticket;
            }
        }
        return null;
    }

    public boolean removeTicket(int ticketId) {
        Ticket ticket = findTicket(ticketId);
        if (ticket == null) {
            return false;
        }
        tickets.remove(ticket);
        return true;
    }

    public List<Ticket> getTicketsByCustomer(Customer customer) {
        List<Ticket> customerTickets = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getCustomer().getUserId() == customer.getUserId()) {
                customerTickets.add(ticket);
            }
        }
        return customerTickets;
    }
}
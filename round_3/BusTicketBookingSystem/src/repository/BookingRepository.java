package repository;

import model.Ticket;
import java.util.*;

public class BookingRepository {
    private final Map<String, Ticket> ticketMap = new HashMap<>();

    public void save(Ticket ticket) {
        ticketMap.put(ticket.getTicketId(), ticket);
    }

    public Optional<Ticket> findById(String ticketId) {
        return Optional.ofNullable(ticketMap.get(ticketId));
    }

    public List<Ticket> findAll() {
        return new ArrayList<>(ticketMap.values());
    }

    public List<Ticket> findByCustomerId(String customerId) {
        List<Ticket> result = new ArrayList<>();
        for (Ticket t : ticketMap.values()) {
            if (t.getCustomerId().equals(customerId)) {
                result.add(t);
            }
        }
        return result;
    }
}
package database;

import model.Customer;
import model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketDatabase {
    List<Ticket> tickDB = new ArrayList<>();

    public boolean addTicket(Ticket ticket) {
        if (ticket == null) {
            return false;
        }
        return tickDB.add(ticket);
    }

    public Ticket getById(String id) {
        if (id == null) {
            return null;
        }
        for (Ticket tic : tickDB) {
            if (tic.getTicketId().equals(id)) {
                return tic;
            }
        }
        return null;
    }

}

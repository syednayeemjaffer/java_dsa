package database;

import model.Ticket;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TicketDatabase {
    private final List<Ticket> tickDB = new ArrayList<>();

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

    public List<Ticket> getByCusId(String cusId) {
        List<Ticket> list = new ArrayList<>();
        if (cusId == null) {
            return list;
        }
        for (Ticket tic : tickDB) {
            if (tic.getCusBooked().getId().equals(cusId)) {
                list.add(tic);
            }
        }
        return list;
    }

    public List<Ticket> getTickDB() {
        return new ArrayList<>(tickDB);
    }

    public boolean deleteTicketById(String id) {
        Ticket ticket = getById(id);
        if (ticket == null) {
            return false;
        }
        return tickDB.remove(ticket);
    }

    public List<Ticket> getTicketByDate(LocalDate date){
        List<Ticket> list = new ArrayList<>();
        for (Ticket tick : tickDB){
            if(tick.getBookedDate().toLocalDate().equals(date)){
                list.add(tick);
            }
        }
        return list;
    }
}

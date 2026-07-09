package service;

import model.Bus;
import model.Ticket;
import repository.BookingRepository;
import repository.BusRepository;

import java.util.List;

public class BusService {

    private final BusRepository busRepository;
    private final BookingRepository bookingRepository;
    public BusService() {
        busRepository = new BusRepository();
        bookingRepository = new BookingRepository();
    }

    public boolean addBus(Bus bus) {
        if (busRepository.findBusByNumber(bus.getBusNumber()) != null) {
            System.out.println("Bus Number already exists.");
            return false;
        }

        if (bus.getFare() <= 0) {
            System.out.println("Invalid Fare.");
            return false;
        }
        if (bus.getTotalSeats() <= 0) {
            System.out.println("Invalid Seat Count.");
            return false;
        }

        busRepository.addBus(bus);
        return true;
    }

    public List<Bus> getAllBuses() {
        return busRepository.getAllBuses();
    }

    public Bus searchBus(int busId) {
        return busRepository.findBusById(busId);
    }

    public boolean deleteBus(int busId) {
        return busRepository.deleteBus(busId);
    }

    public boolean updateFare(int busId, double fare) {
        return busRepository.updateFare(busId, fare);
    }

    public void saveTicket(Ticket ticket) {
        bookingRepository.addTicket(ticket);
    }
}
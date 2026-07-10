package service;

import exception.BusNotFoundException;
import model.Bus;
import repository.BusRepository;
import util.IDGenerator;

import java.time.LocalDateTime;
import java.util.List;

public class BusService {
    private final BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public Bus addBus(String busNumber, String source, String destination,
                      LocalDateTime departure, int totalSeats, double fare) {
        String id = IDGenerator.generateBusId();
        Bus bus = new Bus(id, busNumber, source, destination, departure, totalSeats, fare);
        busRepository.save(bus);
        return bus;
    }

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public List<Bus> searchBuses(String source, String destination) {
        return busRepository.searchByRoute(source, destination);
    }

    public Bus getBusById(String busId) {
        return busRepository.findById(busId)
                .orElseThrow(() -> new BusNotFoundException("Bus with ID " + busId + " not found."));
    }
}
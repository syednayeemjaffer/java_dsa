package repository;

import model.Bus;

import java.util.ArrayList;
import java.util.List;

public class BusRepository {
    // In-memory database
    private final List<Bus> buses;
    public BusRepository() {
        buses = new ArrayList<>();
    }
    /**
     * Add a new bus
     */
    public void addBus(Bus bus) {
        buses.add(bus);
    }
    /**
     * Return all buses
     */
    public List<Bus> getAllBuses() {
        return new ArrayList<>(buses);
    }    /**
     * Find a bus using busId
     */
    public Bus findBusById(int busId) {
        for (Bus bus : buses) {
            if (bus.getBusId() == busId) {
                return bus;
            }
        }
        return null;
    }
    /**
     * Delete bus
     */
    public boolean deleteBus(int busId) {
        Bus bus = findBusById(busId);
        if (bus != null) {
            buses.remove(bus);
            return true;
        }
        return false;
    }
    public Bus findBusByNumber(String busNumber) {

        for (Bus bus : buses) {

            if (bus.getBusNumber().equalsIgnoreCase(busNumber)) {
                return bus;
            }

        }

        return null;

    }

    public boolean updateFare(int busId, double newFare) {

        Bus bus = findBusById(busId);

        if (bus == null) {
            return false;
        }

        bus.setFare(newFare);

        return true;

    }
}
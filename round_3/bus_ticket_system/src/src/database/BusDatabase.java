package database;

import model.Bus;

import java.util.ArrayList;
import java.util.List;

public class BusDatabase {
    private final List<Bus> busDB = new ArrayList<>();

    public boolean addBus(Bus bus) {
        if (bus == null) {
            return false;
        }
        return busDB.add(bus);
    }

    public Bus getById(String id) {
        if (id == null) {
            return null;
        }
        for (Bus bus : busDB) {
            if (bus.getId().equals(id)) {
                return bus;
            }
        }
        return null;
    }

    public List<Bus> getBusByRoute(String source, String destination) {
        List<Bus> buses = new ArrayList<>();
        for (Bus bus : busDB) {
            if (bus.getSource().equalsIgnoreCase(source)
                    && bus.getDestination().equalsIgnoreCase(destination)) {
                buses.add(bus);
            }
        }
        return buses;
    }

    public List<Bus> getBusDB() {
        return new ArrayList<>(busDB);
    }
}

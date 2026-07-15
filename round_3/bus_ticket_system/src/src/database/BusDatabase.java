package database;

import model.Bus;

import java.util.ArrayList;
import java.util.List;

public class BusDatabase {
    private List<Bus> busDB = new ArrayList<>();

    public boolean addBus(Bus bus){
        if (bus == null){
            return false;
        }
        busDB.add(bus);
        return true;
    }
    public Bus getById(String id){
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
        return busDB;
    }

}

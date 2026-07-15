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
    public Bus getById(int id){
        for (Bus bus : busDB) {
            if (bus.getId() == id) {
                return bus;
            }
        }
        return null;
    }
    public Bus getBusByRoot(String sour,String dest){
        for (Bus bus : busDB){
            if(bus.getSource() == sour && bus.getDestination() == dest){
                return bus;
            }
        }
        return null;
    }
    public List<Bus> getBusDB() {
        return busDB;
    }

}

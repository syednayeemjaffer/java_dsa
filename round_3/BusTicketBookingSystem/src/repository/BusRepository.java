package repository;

import model.Bus;
import java.util.*;

public class BusRepository {
    private final Map<String, Bus> busMap = new HashMap<>();

    public void save(Bus bus) {
        busMap.put(bus.getId(), bus);
    }

    public Optional<Bus> findById(String id) {
        return Optional.ofNullable(busMap.get(id));
    }

    public List<Bus> findAll() {
        return new ArrayList<>(busMap.values());
    }

    public List<Bus> searchByRoute(String source, String destination) {
        List<Bus> result = new ArrayList<>();
        for (Bus bus : busMap.values()) {
            if (bus.getSource().equalsIgnoreCase(source) &&
                    bus.getDestination().equalsIgnoreCase(destination)) {
                result.add(bus);
            }
        }
        return result;
    }
}
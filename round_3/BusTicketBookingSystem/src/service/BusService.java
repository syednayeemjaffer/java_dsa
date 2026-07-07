package service;

import model.Bus;
import repository.BusRepository;

import java.util.List;

public class BusService {
    private final BusRepository busRepository;

    public BusService() {
        busRepository = new BusRepository();
    }

    public void addBus(Bus bus) {
        busRepository.addBus(bus);
        System.out.println("Bus Added Successfully.");
    }

    public void displayAllBuses() {
        List<Bus> buses = busRepository.getAllBuses();
        if (buses.isEmpty()) {
            System.out.println("No buses available.");
            return;
        }
        for (Bus bus : buses) {
            System.out.println(bus);
        }
    }
    public Bus searchBus(int busId) {
        return busRepository.findBusById(busId);
    }

    public void deleteBus(int busId) {
        boolean deleted = busRepository.deleteBus(busId);
        if (deleted) {
            System.out.println("Bus deleted successfully.");
        } else {
            System.out.println("Bus not found.");
        }
    }

}
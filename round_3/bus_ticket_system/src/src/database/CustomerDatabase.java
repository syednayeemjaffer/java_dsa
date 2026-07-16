package database;

import model.Bus;
import model.Customer;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class CustomerDatabase {
    private List<Customer> cusDB = new ArrayList<>();

    public boolean addBus(Customer bus){
        if (bus == null){
            return false;
        }
        cusDB.add(bus);
        return true;
    }
    public Customer getById(String id){
        for (Customer cus : cusDB) {
            if (cus.getId().equals(id)) {
                return cus;
            }
        }
        return null;
    }
    public List<Customer> getcusDB() {
        return cusDB;
    }

}

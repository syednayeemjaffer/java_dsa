package database;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDatabase {
    private final List<Customer> cusDB = new ArrayList<>();

    public boolean addCustomer(Customer customer) {
        if (customer == null) {
            return false;
        }
        return cusDB.add(customer);
    }

    public Customer getById(String id) {
        if (id == null) {
            return null;
        }
        for (Customer cus : cusDB) {
            if (cus.getId().equals(id)) {
                return cus;
            }
        }
        return null;
    }

    public boolean isEmailTaken(String email) {
        if (email == null) {
            return false;
        }
        for (Customer cus : cusDB) {
            if (cus.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean deleteCustomer(String id) {
        Customer cus = getById(id);
        if (cus == null) {
            return false;
        }
        return cusDB.remove(cus);
    }

    public List<Customer> getCusDB() {
        return new ArrayList<>(cusDB);
    }
}

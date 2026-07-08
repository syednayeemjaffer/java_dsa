package repository;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private final List<Customer> customers;

    public CustomerRepository() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer findByUsername(String username) {
        for (Customer customer : customers) {
            if (customer.getUsername().equalsIgnoreCase(username)) {
                return customer;
            }
        }
        return null;
    }

    public Customer login(String username, String password) {
        for (Customer customer : customers) {
            if (customer.getUsername().equalsIgnoreCase(username)
                    && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }
}
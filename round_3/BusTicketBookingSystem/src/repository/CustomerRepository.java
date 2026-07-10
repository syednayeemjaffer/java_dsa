package repository;

import model.Customer;
import java.util.*;

public class CustomerRepository {
    private final Map<String, Customer> customerMap = new HashMap<>();

    public void save(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    public Optional<Customer> findById(String id) {
        return Optional.ofNullable(customerMap.get(id));
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }
}
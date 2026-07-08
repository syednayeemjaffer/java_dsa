package service;

import model.Customer;
import repository.CustomerRepository;

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService() {
        customerRepository = new CustomerRepository();
    }

    public boolean register(Customer customer) {
        if (customerRepository.findByUsername(customer.getUsername()) != null) {
            return false;
        }
        customerRepository.addCustomer(customer);
        return true;
    }

    public Customer login(String username, String password) {
        return customerRepository.login(username, password);
    }
}
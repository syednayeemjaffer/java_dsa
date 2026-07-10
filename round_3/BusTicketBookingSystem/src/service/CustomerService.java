package service;

import model.Address;
import model.Customer;
import repository.CustomerRepository;
import util.IDGenerator;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer registerCustomer(String name, String phone, String email,
                                     String street, String city, String zip) {
        String id = IDGenerator.generateCustomerId();
        Address address = new Address(street, city, zip);
        Customer customer = new Customer(id, name, phone, email, address);
        customerRepository.save(customer);
        return customer;
    }

    public Optional<Customer> findCustomerById(String id) {
        return customerRepository.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
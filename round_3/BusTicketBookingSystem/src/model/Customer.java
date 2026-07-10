package model;

public class Customer {
    private final String id;
    private String name;
    private String phone;
    private String email;
    private Address address;

    public Customer(String id, String name, String phone, String email, Address address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public Address getAddress() { return address; }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Phone: %s | Email: %s",
                id, name, phone, email);
    }
}
package service;

import database.CustomerDatabase;
import database.TicketDatabase;
import enums.Gender;
import helper.IDGenerator;
import helper.ScannerHelper;
import helper.TicketPrinter;
import model.Customer;
import model.Ticket;

import java.util.List;
import java.util.Locale;

public class CustomerService {
    private final ScannerHelper s = new ScannerHelper();
    private final CustomerDatabase cusDB;
    private final TicketDatabase tickDB;

    public CustomerService(CustomerDatabase cusDB, TicketDatabase tickDB) {
        this.cusDB = cusDB;
        this.tickDB = tickDB;
    }

    public void customerService() {
        while (true) {
            System.out.println("\n=========== CUSTOMER MANAGEMENT ===========");
            System.out.println("1. Register Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Search Customer by ID");
            System.out.println("4. Search Customer by Mobile");
            System.out.println("5. Update Customer");
            System.out.println("6. Delete Customer");
            System.out.println("7. View Tickets Booked by Customer");
            System.out.println("8. Back");

            int choice = s.intValue("Enter your choice: ");
            switch (choice) {
                case 1:
                    registerCustomer();
                    break;
                case 2:
                    viewCustomers();
                    break;
                case 3:
                    searchById();
                    break;
                case 4:
                    searchByPhoneNo();
                    break;
                case 5:
                    update();
                    break;
                case 6:
                    delete();
                    break;
                case 7:
                    ticketBookedByCustomer();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void registerCustomer() {
        String name = s.stringValue("Name: ");
        Gender gender = readGender();
        int age = s.intValue("Age: ");
        long phNo = s.longValue("PhNo: ");
        String email = s.stringValue("Email: ");

        if (cusDB.isEmailTaken(email)) {
            System.out.println("This email is already registered.");
            return;
        }

        Customer cus = new Customer(IDGenerator.generateID(), name, gender, age, phNo, email);
        boolean result = cusDB.addCustomer(cus);

        if (!result) {
            System.out.println("Error occurred while registering the customer.");
            return;
        }
        System.out.println("Customer registered successfully. ID: " + cus.getId());
    }

    private Gender readGender() {
        while (true) {
            String input = s.stringValue("Gender (MALE/FEMALE/OTHER): ");
            try {
                return Gender.valueOf(input.toUpperCase(Locale.ROOT));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid gender. Please enter MALE, FEMALE, or OTHER.");
            }
        }
    }

    private void viewCustomers() {
        List<Customer> list = cusDB.getCusDB();

        if (list.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        printHeader();
        for (Customer cus : list) {
            printCustomerRow(cus);
        }
    }

    private void searchById() {
        String id = s.stringValue("Enter the ID: ");
        Customer cus = cusDB.getById(id);

        if (cus == null) {
            System.out.println("Customer not found. Please enter a valid ID.");
            return;
        }

        printHeader();
        printCustomerRow(cus);
    }

    private void searchByPhoneNo() {
        long phNo = s.longValue("Enter PhNo: ");
        List<Customer> list = cusDB.getCusDB();

        for (Customer cus : list) {
            if (cus.getPhNo() == phNo) {
                printHeader();
                printCustomerRow(cus);
                return;
            }
        }
        System.out.println("Phone number not found.");
    }

    private void update() {
        String id = s.stringValue("Enter ID: ");
        Customer cus = cusDB.getById(id);

        if (cus == null) {
            System.out.println("Customer not found. Please enter a valid ID.");
            return;
        }

        System.out.println("Leave a field blank to keep its current value.");

        String name = s.stringValue("Name [" + cus.getName() + "]: ");
        String genderInput = s.stringValue("Gender (MALE/FEMALE/OTHER) [" + cus.getGender() + "]: ");
        String ageInput = s.stringValue("Age [" + cus.getAge() + "]: ");
        String phNoInput = s.stringValue("Phone No [" + cus.getPhNo() + "]: ");
        String email = s.stringValue("Email [" + cus.getEmail() + "]: ");

        if (!name.isBlank()) {
            cus.setName(name);
        }

        if (!genderInput.isBlank()) {
            try {
                cus.setGender(Gender.valueOf(genderInput.toUpperCase(Locale.ROOT)));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid gender. Gender not updated.");
            }
        }

        if (!ageInput.isBlank()) {
            try {
                cus.setAge(Integer.parseInt(ageInput));
            } catch (NumberFormatException e) {
                System.out.println("Invalid age. Age not updated.");
            }
        }

        if (!phNoInput.isBlank()) {
            try {
                cus.setPhNo(Long.parseLong(phNoInput));
            } catch (NumberFormatException e) {
                System.out.println("Invalid phone number. Phone number not updated.");
            }
        }

        if (!email.isBlank()) {
            if (cusDB.isEmailTaken(email) && !email.equalsIgnoreCase(cus.getEmail())) {
                System.out.println("This email is already registered. Email not updated.");
            } else {
                cus.setEmail(email);
            }
        }

        System.out.println("Customer updated successfully.");
    }

    private void delete() {
        String id = s.stringValue("Enter ID: ");
        if (cusDB.deleteCustomer(id)) {
            System.out.println("Customer deleted successfully.");
        } else {
            System.out.println("Customer not found. Please enter a valid ID.");
        }
    }

    private void ticketBookedByCustomer() {
        String id = s.stringValue("Enter customer ID: ");
        List<Ticket> tickets = tickDB.getByCusId(id);

        if (tickets.isEmpty()) {
            System.out.println("No tickets found for this customer ID.");
            return;
        }

        for (Ticket ticket : tickets) {
            TicketPrinter.print(ticket);
        }
    }

    private void printHeader() {
        System.out.println("=============================================");
        System.out.printf("%-8s %-10s %-8s %-5s %-12s %-20s%n",
                "Id", "Name", "Gender", "Age", "PhNo", "Email");
        System.out.println("=============================================");
    }

    private void printCustomerRow(Customer cus) {
        System.out.printf("%-8s %-10s %-8s %-5d %-12d %-20s%n",
                cus.getId(),
                cus.getName(),
                cus.getGender(),
                cus.getAge(),
                cus.getPhNo(),
                cus.getEmail());
    }
}

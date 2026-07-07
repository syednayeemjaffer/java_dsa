package model;

public class Customer extends User {

    public Customer() {
    }

    public Customer(int userId,
                    String name,
                    String phoneNumber,
                    String email,
                    String username,
                    String password) {

        super(userId,
                name,
                phoneNumber,
                email,
                username,
                password);
    }

    public void showRole() {
        System.out.println("Logged in as CUSTOMER");
    }
}
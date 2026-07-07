package model;

public class Admin extends User {

    public Admin() {}

    public Admin(int userId,
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

        System.out.println("Logged in as ADMIN");

    }

}
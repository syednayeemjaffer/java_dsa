package service;

import enums.Gender;
import helper.IDGenerator;
import model.Customer;

import java.util.Scanner;

public class CustomerService {
    Scanner s = new Scanner(System.in);
    public Customer cus1 = new Customer(IDGenerator.generateID(),"Syed", Gender.MALE,22,9344242496L,"123@gmail.com");
    public Customer cus2 = new Customer(IDGenerator.generateID(),"nasreen", Gender.FEMALE,21,9344242496L,"123@gmail.com");

    public void customerService(){
        while (true){
            System.out.println("===========CUSTOMER MANAGEMENT============\n");
            System.out.println("1. Register Customer");
            System.out.println("2. View All Customers\n");
            System.out.println("3. Search Customer by ID");
            System.out.println("4. Search Customer by Mobile");
            System.out.println("5. Update Customer");
            System.out.println("6. Delete Customer");
            System.out.println("7. Back");

        }
    }

}

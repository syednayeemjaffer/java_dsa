package service;

import database.CustomerDatabase;
import enums.Gender;
import helper.IDGenerator;
import model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CustomerService {
    Scanner s = new Scanner(System.in);
    public Customer cus1 = new Customer(IDGenerator.generateID(),"Syed", Gender.MALE,22,9344242496L,"123@gmail.com");
    public Customer cus2 = new Customer(IDGenerator.generateID(),"nasreen", Gender.FEMALE,21,9344242496L,"1234@gmail.com");
    CustomerDatabase cusDB = new CustomerDatabase();

    public void customerService(){
        cusDB.addBus(cus1);cusDB.addBus(cus2);
        while (true){
            System.out.println("===========CUSTOMER MANAGEMENT============\n");
            System.out.println("1. Register Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Search Customer by ID");
            System.out.println("4. Search Customer by Mobile");
            System.out.println("5. Update Customer");
            System.out.println("6. Delete Customer");
            System.out.println("7. Back");
            int choice = s.nextInt();
            s.nextLine();

            switch (choice){
                case 1:
                    registerCus();
                    break;
                case 2:
                    viewCustomers();
                    break;
                case 3:
                    searchById();
                    break;
                case 4:
                    searchByPhno();
                    break;
                case 5:
                    update();
                    break;
                case 6:
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;

            }
        }
    }

    private void registerCus(){
        System.out.print("Name: ");
        String name = s.nextLine();
        System.out.print("Gender: ");
        Gender gen = Gender.valueOf(s.nextLine().toUpperCase(Locale.ROOT));
        System.out.print("Age: ");
        int age = s.nextInt();
        s.nextLine();
        System.out.print("PhNo: ");
        long phNo = s.nextLong();
        s.nextLine();
        System.out.print("Email: ");
        String email = s.nextLine();

        Customer cus = new Customer(IDGenerator.generateID(),name,gen,age,phNo,email);
        registerUser(cus);
    }
    private void registerUser(Customer cus){
        List<Customer> list = cusDB.getcusDB();
        for (Customer c : list){
            if(cus.getEmail() == c.getEmail()){
                System.out.println("Email is already take..");
            }
        }
        boolean result = cusDB.addBus(cus);
        if (!result){
            System.out.println("Error occur while registor");
            new Error("Register failed");
            return;
        }
        System.out.println("Usered is now registered..");
    }

    private void viewCustomers(){
        List<Customer> list = cusDB.getcusDB();
        System.out.println("=============================================");
        System.out.printf("%-4s %-10s %-10s %-10s %-10s %-10s%n",
                "Id","Name","Gender","Age","PhNo","Gmail");
        for (Customer cus: list){
            System.out.printf("%-4s %-10s %-10s %-10d %-10d %-10s%n",
                    cus.getId(),
                    cus.getName(),
                    cus.getGender(),
                    cus.getAge(),
                    cus.getPhNo(),
                    cus.getEmail(),"\n"
            );
        }
    }
    private void searchById(){
        System.out.print("Enter the ID: ");
        String str = s.nextLine();
        Customer cus = searchCusById(str);
        System.out.print("====================================== \n");
        System.out.printf("%-4s %-10s %-10s %-10d %-10d %-10s%n",
                cus.getId(),
                cus.getName(),
                cus.getGender(),
                cus.getAge(),
                cus.getPhNo(),
                cus.getEmail()
        );
    }
    private Customer searchCusById(String str){
        return cusDB.getById(str);
    }

    private void searchByPhno(){
        System.out.print("Enter phno: ");
        long phno = s.nextLong();
        searchCusByPhno(phno);
    }
    private void searchCusByPhno(long phno){
        List<Customer> list = cusDB.getcusDB();
        for (Customer cus : list){
            if(cus.getPhNo() == phno){
                System.out.println("=============================================");
                System.out.printf("%-4s %-10s %-10s %-10s %-10s %-10s%n",
                        "Id","Name","Gender","Age","PhNo","Gmail");
                System.out.printf("%-4s %-10s %-10s %-10d %-10d %-10s%n",
                        cus.getId(),
                        cus.getName(),
                        cus.getGender(),
                        cus.getAge(),
                        cus.getPhNo(),
                        cus.getEmail(),"\n"
                );
                return;
            }
        }
        System.out.println("Phno is not found...");
    }
    private void update(){
        System
        System.out.print("Name: ");
        String name = s.nextLine();
        System.out.print("Gender: ");
        Gender gen = Gender.valueOf(s.nextLine().toUpperCase(Locale.ROOT));
        System.out.print("Age: ");
        int age = s.nextInt();
        s.nextLine();
        System.out.print("PhNo: ");
        long phNo = s.nextLong();
        s.nextLine();
        System.out.print("Email: ");
        String email = s.nextLine();
    }

}

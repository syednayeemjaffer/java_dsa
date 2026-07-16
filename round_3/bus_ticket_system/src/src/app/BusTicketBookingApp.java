package app;

import database.BusDatabase;
import helper.IDGenerator;
import model.Bus;
import service.BusService;
import service.CustomerService;

import java.util.List;
import java.util.Scanner;

public class BusTicketBookingApp {

    Scanner s = new Scanner(System.in);
    BusService busservice = new BusService();
    CustomerService cusService = new CustomerService();
    public  void start(){
        while (true){
            System.out.println("========== Welcome ==========");
            System.out.println("1. Bus Service");
            System.out.println("2. Customer Service");

            int choice;
            choice = s.nextInt();
            s.nextLine();
            switch (choice){
                case 1:
                    busservice.busService();
                    break;
                case 2:
                    cusService.customerService();
                    break;
            }
        }

    }

    //view all buses

}

package model;

import helper.IDGenerator;

import java.util.ArrayList;

public class WaitingCustomer {
    private final String waitingID;
    private final Customer waitingCus;
    private final Bus waitingBus;
    private final ArrayList<Integer> seatWanted;

    public WaitingCustomer(Customer cus,Bus bus,ArrayList<Integer>seat){
        this.waitingID = IDGenerator.generateID();
        this.waitingCus = cus;
        this.waitingBus = bus;
        this.seatWanted = seat;
    }

}

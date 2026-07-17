package model;

import java.util.HashMap;

public class Seat {
    private final int totalSeat;
    private final int availableSeat;
    private final HashMap<Integer,Customer> seatStatus;

    public Seat(int totalSeat) {
        this.totalSeat = totalSeat;
        this.availableSeat = totalSeat;
        this.seatStatus = new HashMap<>();
        for (int i = 1;i<=totalSeat;i++){
            seatStatus.put(i,null);

        }
    }
    public boolean seatBooking(Customer cus,int num){
        if(seatStatus.get(num) != null){
            return false;
        }
        seatStatus.replace(num,cus);
        return true;
    }
    public boolean seatDelete(Customer cus,int num){
        if(seatStatus.get(num) != cus){
            System.out.println("You are not the person booked");
            return false;
        }
        seatStatus.replace(num,null);
        return true;
    }
    public int getTotalSeat() {
        return totalSeat;
    }

    public HashMap<Integer, Customer> getAllSeatStatus() {
        return seatStatus;
    }
    public boolean getSeatBookedStatus(int seat){
        if(seatStatus.get(seat) == null){
            return false;
        }
        return true;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }
}

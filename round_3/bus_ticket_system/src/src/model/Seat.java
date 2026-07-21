package model;

import java.util.HashMap;
import java.util.Map;

public class Seat {
    private final int totalSeat;
    private int availableSeat;
    private final Map<Integer, Customer> seatStatus;

    public Seat(int totalSeat) {
        this.totalSeat = totalSeat;
        this.availableSeat = totalSeat;
        this.seatStatus = new HashMap<>();
        for (int i = 1; i <= totalSeat; i++) {
            seatStatus.put(i, null);
        }
    }

    public boolean isValidSeatNo(int num) {
        return num >= 1 && num <= totalSeat;
    }

    public boolean seatBooking(Customer cus, int num) {
        if (!isValidSeatNo(num) || seatStatus.get(num) != null) {
            return false;
        }
        seatStatus.put(num, cus);
        availableSeat--;
        return true;
    }

    public boolean seatDelete(Customer cus, int num) {
        if (!isValidSeatNo(num) || seatStatus.get(num) != cus) {
            return false;
        }
        seatStatus.put(num, null);
        availableSeat++;
        return true;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public Map<Integer, Customer> getAllSeatStatus() {
        return new HashMap<>(seatStatus);
    }

    public boolean getSeatBookedStatus(int seat) {
        return isValidSeatNo(seat) && seatStatus.get(seat) != null;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }
}

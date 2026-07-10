package model;

import enums.Gender;

public class Passenger {
    private String name;
    private int age;
    private Gender gender;
    private int seatNumber;

    public Passenger(String name, int age, Gender gender, int seatNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.seatNumber = seatNumber;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public Gender getGender() { return gender; }
    public int getSeatNumber() { return seatNumber; }

    @Override
    public String toString() {
        return String.format("%-20s | Age: %2d | %-6s | Seat: %2d",
                name, age, gender, seatNumber);
    }
}
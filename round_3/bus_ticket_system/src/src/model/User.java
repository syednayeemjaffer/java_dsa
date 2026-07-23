package model;

import enums.Gender;

public class User {
    private final String id;
    private String name;
    private Gender gender;
    private int age;
    private long phNo;
    private String email;
    private int totalTicket;

    public User(String id, String name, Gender gender, int age, long phNo, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phNo = phNo;
        this.email = email;
        this.totalTicket = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhNo() {
        return phNo;
    }

    public void setPhNo(long phNo) {
        this.phNo = phNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTotalTicket() {
        return totalTicket;
    }

    public void increaseTotalTicket() {
        totalTicket ++;
    }
    public void decreaseTotalTicket() {
        totalTicket --;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", phNo=" + phNo +
                ", email='" + email + '\'' +
                '}';
    }
}

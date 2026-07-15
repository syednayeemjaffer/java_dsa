package model;

import enums.Gender;

public class User {
    private String id;
    private String name;
    private Gender gender;
    private int age;
    private long phNo;
    private String email;

    public User(String id, String name, Gender gender, int age, long phNo, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phNo = phNo;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public long getPhNo() {
        return phNo;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age='" + age + '\'' +
                ", phNo=" + phNo +
                ", email='" + email + '\'' +
                '}';
    }
}

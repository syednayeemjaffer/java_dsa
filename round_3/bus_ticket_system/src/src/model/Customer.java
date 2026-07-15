package model;

import enums.Gender;

public class Customer extends User{
    public Customer (String id, String name, Gender gender, int age, long phNo, String email){
        super(id,name,gender,age,phNo,email);
    }
}

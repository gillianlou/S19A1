package com.petservice;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    private List<Dog> pets = new ArrayList<>();

    public Customer(int id, String name, String lastName, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Customer(int id, String name, String lastName, String email){
        this(id, name, lastName, email, null, null);
    }

    public void addPet(Dog dog){
        if(dog.getOwner()!=null){
            dog.getOwner().removePet(dog);
        }
        dog.setOwner(this);
        pets.add(dog);
    }

    public void removePet(Dog dog){
        if(dog.getOwner()!=this){
            return;
        }
        dog.setOwner(null);
        pets.remove(dog);
    }

    public int getPetsCount(){
        return pets.size();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


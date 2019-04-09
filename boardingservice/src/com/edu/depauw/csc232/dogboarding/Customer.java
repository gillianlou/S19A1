////////////////////////////////////////////////////////////////////////////////
// File:             Customer.java
// Course:           CSC232A, Spring 2019
// Author:          Gillian Hughes, Summer Asad
// Acknowledgements:
// Online sources:
////////////////////////////////////////////////////////////////////////////////

package com.edu.depauw.csc232.dogboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * The <code>Customer</code> class represents a customer object in a pet boarding simulation
 *
 * @author Gillian Hughes <gillianhughes_2021@depauw.edu>
 * @author Summer Asad <summerasad_2020@depauw.edu>
 */
public class Customer {

    private int id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    private List<Dog> pets = new ArrayList<>();

    /**
     * Construct a Customer object given a PARAMETERS id, name, last name,
     * email, phone, address, pets
     *
     * @param id
     *            The customer's unique id
     * @param name
     *            The customer's name
     * @param lastName
     *            The customer's last name
     * @param email
     *            The customer's email
     * @param phone
     *            The customer's phone number
     * @param address
     *            the customer's address
     */
    public Customer(int id, String name, String lastName, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Constructs customer object given PARAMETERS id, name, lastName, email
     * @param id
     *              The customer's id
     * @param name
     *              The customer's name
     * @param lastName
     *              The customer's last name
     * @param email
     *              The customer's email
     */

    public Customer(int id, String name, String lastName, String email){
        this(id, name, lastName, email, null, null);
    }

    /**
     * Method adds dog to owner. Owner is a customer object.
     * @param dog
     *              An instance of class Dog
     */
    public void addPet(Dog dog){
        if(dog.getOwner()!=null){
            dog.getOwner().removePet(dog);
        }
        dog.setOwner(this);
        pets.add(dog);
    }

    /**
     * method removes dog from owner
     * @param dog
     *              An instance of class Dog
     */
    public void removePet(Dog dog){
        if(dog.getOwner()!=this){
            return;
        }
        dog.setOwner(null);
        pets.remove(dog);
    }

    /**
     * method returns number of pets
     * @return
     *              returns amount of pets a customer has
     */
    public int getDogCount(){
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

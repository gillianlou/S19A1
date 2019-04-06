package com.petservice;

import java.util.ArrayList;
import java.util.List;

public class PetService {
    private List<Customer> customers = new ArrayList<>();
    private List<Dog> dogs = new ArrayList<>();

    private int nextId;

    public Customer newCustomer(String name, String lastName, String email) {
        return newCustomer(name, lastName, email, null, null);
    }

    public Customer newCustomer(String name, String lastName, String email, String phone, String address) {
        System.out.println("Registering new Customer...");
        Customer customer = new Customer(nextId++, name, lastName, email, phone, address);
        customers.add(customer);

        System.out.println("Customer: " + name + " registered with id " + customer.getId());

        return customer;
    }

    public void removeCustomer(Customer customer) {
        if(customers.remove(customer)){
            System.out.println("Customer: " + customer.getName() + " unregistered");
        }
        else {
            System.out.println(customer.getId() + "is not a customer");
        }
    }

    public void boardDog(Dog dog) {
     System.out.println("boarding dog" + dog.getName());

     if (dog.getOwner()==null){
         System.out.println("dog no have owner");
         return;
     }
     if (!customers.contains(dog.getOwner())){
         System.out.println("the owner is not a customer");
         return;
     }
     dogs.add(dog);

     System.out.println(dog.getName() + " boarded");

     notifyBoarding(dog.getOwner(), dog);
    }

    public void pickUpDog(Dog dog){
        if(!dogs.contains(dog)){
            System.out.println("This dog is not in our system; cannot be picked up.");
            return;
        }
        dogs.remove(dog);

        System.out.println("picking up dog " + dog.getName());

        notifyPickingUp(dog.getOwner(), dog);
    }

    private void notifyBoarding(Customer customer, Dog dog) {
        sendEmail(customer, dog.getName() + " was boarded", "Your lovely " + dog.getName() + " was succesfully boarded. Thank you for choosing us.");
    }

    private void notifyPickingUp(Customer customer, Dog dog) {
        sendEmail(customer, dog.getName() + " was picked up", dog.getName() + " was successfully picked up. We hope you had a great experience with us.");
    }

    public void sendEmail(Customer customer, String subject, String body) {
        System.out.println("Sending email to customer " + customer.getId());

        if(!customers.contains(customer)) {
            System.out.println(customer.getId() + " is not a customer");
            return;
        }

        System.out.println("Address: " + customer.getEmail());
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);

        System.out.println("Email sent");
    }
}
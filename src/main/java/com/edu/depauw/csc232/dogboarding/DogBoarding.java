////////////////////////////////////////////////////////////////////////////////
// File:             PetService.java
// Course:           CSC232A, Spring 2019
// Author:          Gillian Hughes, Summer Asad
// Acknowledgements:
// Online sources:
////////////////////////////////////////////////////////////////////////////////

package com.edu.depauw.csc232.dogboarding;

import java.util.ArrayList;
import java.util.List;

    /**
     * The <code>DogBoarding</code> class represents the user interface for a pet boarding employee to board dogs
     *
     * @author Gillian Hughes <gillianhughes_2021@depauw.edu>
     * @author Summer Asad <summerasad_2020@depauw.edu>
     */

    public class DogBoarding {
        private List<Customer> customers = new ArrayList<>();
        private List<Dog> dogs = new ArrayList<>();

        private int nextId;

        /**
         * Calls constructor for Customer class, adds customer to list of customers
         * @param name
         * @param lastName
         * @param email
         * @return
         */
        public Customer newCustomer(String name, String lastName, String email) {
            return newCustomer(name, lastName, email, null, null);
        }

        /**
         * Calls constructor for Customer class, adds customer to list of customers
         * @param name
         * @param lastName
         * @param email
         * @param phone
         * @param address
         * @return
         */
        public Customer newCustomer(String name, String lastName, String email, String phone, String address) {
            System.out.println("Registering new Customer...");
            Customer customer = new Customer(nextId++, name, lastName, email, phone, address);
            customers.add(customer);

            System.out.println("Customer: " + name + " registered with id " + customer.getId());

            return customer;
        }

        /**
         * Removes customer from list of customers
         * @param customer
         */
        public void removeCustomer(Customer customer) {
            if(customers.remove(customer)){
                System.out.println("Customer: " + customer.getName() + " unregistered");
            }
            else {
                System.out.println(customer.getId() + "is not a customer");
            }
        }

        /**
         * adds dog to list of boarded dogs
         * @param dog
         */
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

        /**
         * removes dog from list of boarded dogs
         * @param dog
         */
        public void pickUpDog(Dog dog){
            if(!dogs.contains(dog)){
                System.out.println("This dog is not in our system; cannot be picked up.");
                return;
            }
            dogs.remove(dog);

            System.out.println("picking up dog " + dog.getName());

            notifyPickingUp(dog.getOwner(), dog);
        }

        /**
         * notifies the customer that their dog is added to the system for boarding via email
         * @param customer
         * @param dog
         */
        private void notifyBoarding(Customer customer, Dog dog) {
            sendEmail(customer, dog.getName() + " was boarded", "Your lovely " + dog.getName() + " was succesfully boarded. Thank you for choosing us.");
        }

        /**
         * notifies the customer that their dog has been picked up via email
         * @param customer
         * @param dog
         */
        private void notifyPickingUp(Customer customer, Dog dog) {
            sendEmail(customer, dog.getName() + " was picked up", dog.getName() + " was successfully picked up. We hope you had a great experience with us.");
        }

        /**
         * method that creates the content of an email
         * @param customer
         * @param subject
         * @param body
         */
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

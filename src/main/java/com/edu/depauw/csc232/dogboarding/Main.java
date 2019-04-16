
package com.edu.depauw.csc232.dogboarding;

public class Main {

    public static void main(String[] args) {
        System.out.println("The program starts");

        DogBoarding system = new DogBoarding();



        Customer bob = system.newCustomer("Bob", "Hughes", "bobhughes");

        Dog berkley = new Dog("Berkley", 3, "Mutt");
        bob.addPet(berkley);

        system.boardDog(berkley);
        system.pickUpDog(berkley);

        system.removeCustomer(bob);
    }
}

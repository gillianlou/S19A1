////////////////////////////////////////////////////////////////////////////////
// File:             Dog.java
// Course:           CSC232A, Spring 2019
// Author:          Gillian Hughes, Summer Asad
// Acknowledgements:
// Online sources:
////////////////////////////////////////////////////////////////////////////////

package com.edu.depauw.csc232.dogboarding;

/**
 * The <code>Dog</code> class represents a dog object in a pet boarding simulation
 *
 * @author Gillian Hughes <gillianhughes_2021@depauw.edu>
 * @author Summer Asad <summerasad_2020@depauw.edu>
 */

public class Dog {
    private String name;
    private int age;
    private String breed;

    private Customer owner;

    /**
     * constructs a dog with PARAMETERS name, age, breed
     * @param name
     * @param age
     * @param breed
     */
    public Dog(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public Customer getOwner() {
        return owner;
    }

    /**
     * sets owner of dog--of type customer
     * @param owner
     */
    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}

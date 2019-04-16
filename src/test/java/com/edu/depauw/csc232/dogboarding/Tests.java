package com.edu.depauw.csc232.dogboarding;

import static org.junit.Assert.*;
import org.junit.Test;

public class Tests {
    @Test
    public void testPetCount ()
    {
        Dog c = new Dog("Henry", 5, "lab");
        DogBoarding system = new DogBoarding();
        Customer a = new Customer (4, "Gillian", "Hughes", "email.gillianhughes_2021@depauw.edu");
        a.addPet(c);
        assertEquals(1, a.getDogCount());
    }

    @Test
    public void testGetAge ()
    {
        Dog izzy = new Dog("Izzy", 2, "german shepard");
        DogBoarding system = new DogBoarding();
        Customer summer = new Customer (7, "Summer", "Asad", "summerasad_2020@depauw.edu");
        summer.addPet(izzy);
        assertEquals(5, izzy.getAge());
    }

    @Test
    public void testGetBreed ()
    {
        Dog c = new Dog("Henry",5, "lab");
        Customer a = new Customer (4, "Gillian", "Hughes", "gillianhughes_2020@depauw.edu");
        a.addPet(c);
        assertEquals("lab", c.getBreed());
    }
}
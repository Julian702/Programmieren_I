package de.dhbwka.java.exercise.control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class TestLeapYear {
    
    @Test
    public void testleapYear(){
        assertEquals(true, LeapYear.leapYear(2000));
        assertEquals(true, LeapYear.leapYear(2020));
        assertEquals(false, LeapYear.leapYear(2021));
        assertEquals(false, LeapYear.leapYear(2100));
    }
}

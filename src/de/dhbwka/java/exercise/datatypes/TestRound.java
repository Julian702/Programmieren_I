package de.dhbwka.java.exercise.datatypes;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRound {

    @Test
    public void testRound(){
        
        assertEquals(4, Round.round(3.5));
        assertEquals(3, Round.round(3.1415926));
        assertEquals(3, Round.round(2.7182818));
        
        assertEquals(0, Round.round(0));

        assertEquals(-3, Round.round(-2.7182818));
        assertEquals(-3, Round.round(-3.1415926));
        assertEquals(-4, Round.round(-3.5));
    }
}

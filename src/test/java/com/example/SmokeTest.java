package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmokeTest {

    @Test
    public void testSmoke(){
        Person person = new Person("Varun", 21);
        assertEquals("Varun", person.getName());
        assertEquals(21, person.getAge());
    }
}

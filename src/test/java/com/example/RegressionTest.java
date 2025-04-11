package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegressionTest {

    @Test
    void testPersonConstructor() {
        String expectedName = "John";
        int expectedAge = 30;
        Person person = new Person(expectedName, expectedAge);
        assertEquals(expectedName, person.getName());
        assertEquals(expectedAge, person.getAge());
    }

    @Test
    void testGetName() {
        String expectedName = "Alice";
        Person person = new Person(expectedName, 25);
        String actualName = person.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    void testGetAge() {
        int expectedAge = 40;
        Person person = new Person("Bob", expectedAge);
        int actualAge = person.getAge();
        assertEquals(expectedAge, actualAge);
    }

    @Test
    void testPersonWithNullName() {
        Person person = new Person(null, 20);
        assertNull(person.getName());
        assertEquals(20, person.getAge());
    }

    @Test
    void testPersonWithNegativeAge() {
        Person person = new Person("John", -5);
        assertEquals("John", person.getName());
        assertEquals(-5, person.getAge());
    }
}

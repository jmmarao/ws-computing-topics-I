package br.edu.ifsp.class02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private static Person person;

    @BeforeAll
    static void initializePerson() {
        person = new Person("000.000.000-00", "Jones");
    }

    @Test
    @DisplayName("getCpf checker")
    void testCase1() {
        assertEquals("000.000.000-00", person.getCpf());
    }

    @Test
    @DisplayName("setName and getName checker")
    void testCase2() {
        person.setName("John Jones");

        assertEquals("John Jones", person.getName());
    }

    @Test
    @DisplayName("Checking all getters and setters with assertAll")
    void testCase3() {
        person.setName("Thor");
        person.setCpf("111.111.111-11");

        assertAll("Checking getters and setters...",
                () -> assertEquals("Thor", person.getName()),
                () -> assertEquals("111.111.111-11", person.getCpf()),
                () -> assertEquals(1000, person.getAge()),
                () -> assertEquals("SC001", person.getStudentEnrollment())
        );


    }
}
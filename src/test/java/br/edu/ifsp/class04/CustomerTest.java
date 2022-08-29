package br.edu.ifsp.class04;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerTest {
    private Customer customer;

    @BeforeAll
    public void initializeCustomer() {
        customer = new Customer("", "");
    }

    @Test
    @EnabledOnOs({OS.LINUX})
    @Tag("ICorrect")
    public void testCase1() {
        customer.setName("Moon Guard");
        assertEquals("Moon Guard", customer.getName());
    }

    @Test
    @EnabledOnOs({OS.WINDOWS, OS.LINUX})
    @Tag("ToCorrect")
    public void testCase2() {
        customer.setCpf("000.000.000-00");
        assertEquals("000.000.000-00", customer.getCpf());
    }

    @Test
    @EnabledOnJre({JRE.JAVA_17})
    @Tag("ToCorrect")
    public void testCase3() {
        assertTrue(true);
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_17, max = JRE.JAVA_18)
    @Tag("ICorrect")
    public void testCase4() {
        assertTrue(true);
    }
}
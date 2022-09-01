package br.edu.ifsp.class05;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"value1", "value2"})
    public void caseTest(String address) {
        Customer customer = new Customer("She Hulk", "000.000.000-00");
        customer.setAddress(address);
        System.out.println("address: " + address);
        assertEquals(address, customer.getAddress());
    }

    @ParameterizedTest
    @EnumSource
    public void enumTest(ColorCode colorCode) {
        System.out.println(colorCode);
        assertEquals(colorCode, colorCode);
    }

    @ParameterizedTest
    @MethodSource("createArguments")
    public void manyArgumentsTest(String string, int integerNumber, float floatNumber) {
        Customer customer = new Customer(string, Integer.toString(integerNumber));
        assertAll(
                () -> assertEquals(string, customer.getName()),
                () -> assertEquals(Integer.toString(integerNumber), customer.getCpf())
        );
    }

    public static Stream<Arguments> createArguments() {
        return Stream.of(
                Arguments.arguments("Text-1", 1, 1.2f),
                Arguments.arguments("Text-2", 2, 2.3f),
                Arguments.arguments("Text-3", 3, 7.0f)

        );
    }

    @ParameterizedTest
    @CsvSource({
            "string1, 4",
            "string2, 5"
    })
    public void csvSourceTest(String string1, int integerNumber) {
        Customer customer = new Customer(string1, Integer.toString(integerNumber));
        assertAll(
                () -> assertEquals(string1, customer.getName()),
                () -> assertEquals(Integer.toString(integerNumber), customer.getCpf())
        );
    }
}
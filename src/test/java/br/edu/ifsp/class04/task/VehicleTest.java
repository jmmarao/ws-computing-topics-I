package br.edu.ifsp.class04.task;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VehicleTest {
    private Vehicle vehicle;

    @BeforeAll
    public void mockInitialize() {
        vehicle = new Vehicle(VehicleType.LAND, "IFSP-SC000", 4, 135.0);
    }

    @Test
    @EnabledOnOs({OS.LINUX})
    @DisplayName("Checking all getters with assertAll")
    void testCase1() {
        assertAll("Checking getters...",
                () -> assertEquals(VehicleType.LAND, vehicle.getVehicleType()),
                () -> assertEquals("IFSP-SC000", vehicle.getChassis()),
                () -> assertEquals(4, vehicle.getNumberOfWheels()),
                () -> assertEquals(135.0, vehicle.getMotorPower())
        );
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_17, max = JRE.JAVA_18)
    @DisplayName("Checking clone vehicle with customized compare")
    void testCase2() {
        Vehicle vehicleCloned = vehicle.cloneVehicle(vehicle);
        assertEquals(1, vehicleCloned.compareVehicle(vehicle, vehicleCloned));
    }
}
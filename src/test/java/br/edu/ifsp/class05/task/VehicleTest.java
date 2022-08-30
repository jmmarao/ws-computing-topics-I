package br.edu.ifsp.class05.task;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VehicleTest {
    private Vehicle vehicle;
    private List<Vehicle> vehicles = new ArrayList<>();

    @BeforeAll
    public void mockInitialize() {
        vehicle = new Vehicle(VehicleType.LAND, "IFSP-SC000", 4, 135.0);
    }

    @RepeatedTest(value = 3, name = "{displayName}: #{currentRepetition} vehicle")
    @DisplayName("Checking repeated test vehicle")
    public void createRepeatedVehicle(RepetitionInfo rep) {
        vehicles.add(vehicle);

        assertEquals(rep.getCurrentRepetition(), vehicles.size());
    }

    @ParameterizedTest
    @DisplayName("Checking vehicle parameterized")
    @MethodSource("vehicleArguments")
    public void checkCompareVehicle(VehicleType vehicleType, String chassis,
                                    int numberOfWheels, double motorPower) {
        Vehicle vehicleParameterized = new Vehicle(vehicleType, chassis, numberOfWheels, motorPower);
        Vehicle vehicleCloned = vehicle.cloneVehicle(vehicleParameterized);

        assertEquals(1, vehicleCloned.compareVehicle(vehicleParameterized, vehicleCloned));
    }

    static Stream<Arguments> vehicleArguments() {
        return Stream.of(
                Arguments.arguments(VehicleType.LAND, "IFSP-SC001", 4, 147.0),
                Arguments.arguments(VehicleType.LAND, "IFSP-SC002", 4, 150.0),
                Arguments.arguments(VehicleType.LAND, "IFSP-SC003", 4, 127.0)
        );
    }
}
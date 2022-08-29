package br.edu.ifsp.class04.task;

public class Vehicle {
    private VehicleType vehicleType;
    private String chassis;
    private int numberOfWheels;
    private double motorPower;

    public Vehicle(VehicleType vehicleType, String chassis, int numberOfWheels, double motorPower) {
        this.vehicleType = vehicleType;
        this.chassis = chassis;
        this.numberOfWheels = numberOfWheels;
        this.motorPower = motorPower;
    }

    public Vehicle cloneVehicle(Vehicle vehicleToClone) {
        return new Vehicle(vehicleToClone.getVehicleType(), vehicleToClone.getChassis(),
                vehicleToClone.getNumberOfWheels(), vehicleToClone.motorPower);
    }

    public int compareVehicle(Vehicle vehicle1, Vehicle vehicle2) {
        if (vehicle1.getChassis().equals(vehicle2.getChassis()))
            return 1;
        return 0;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getChassis() {
        return chassis;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public double getMotorPower() {
        return motorPower;
    }
}

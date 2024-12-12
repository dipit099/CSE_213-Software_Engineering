package builder;

import product.Vehicle;

public class BikeBuilder extends VehicleBuilder {

    @Override
    public VehicleBuilder buildEngine(String engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public VehicleBuilder buildWheels(int wheels) {
        this.wheels = wheels;
        return this;
    }

    @Override
    public VehicleBuilder buildColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public Vehicle getVehicle() {
        return new Vehicle(engine, wheels, color);
    }
}

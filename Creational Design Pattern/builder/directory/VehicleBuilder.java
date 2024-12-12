package builder;

import product.Vehicle;

public abstract class VehicleBuilder {
    protected String engine;
    protected int wheels;
    protected String color;

    public abstract VehicleBuilder buildEngine(String engine);
    public abstract VehicleBuilder buildWheels(int wheels);
    public abstract VehicleBuilder buildColor(String color);
    
    public abstract Vehicle getVehicle();
}

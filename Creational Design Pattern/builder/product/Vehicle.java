package product;

public class Vehicle {
    private String engine;
    private int wheels;
    private String color;

    // Public constructor, only accessible via the Builder
    public Vehicle(String engine, int wheels, String color) {
        this.engine = engine;
        this.wheels = wheels;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehicle with " + engine + " engine, " + wheels + " wheels, color: " + color;
    }
}

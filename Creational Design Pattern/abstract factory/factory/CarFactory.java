public class CarFactory implements VehicleFactory {
    @Override
    public Engine createEngine() {
        return new CarEngine();
    }

    @Override
    public Tires createTires() {
        return new CarTires();
    }
}

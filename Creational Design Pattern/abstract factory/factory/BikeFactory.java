public class BikeFactory implements VehicleFactory {
    @Override
    public Engine createEngine() {
        return new BikeEngine();
    }

    @Override
    public Tires createTires() {
        return new BikeTires();
    }
}

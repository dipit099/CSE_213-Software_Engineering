public class Main {
    public static void main(String[] args) {
        // Create car parts using CarPartsFactory
        VehicleFactory carPartsFactory = new CarFactory();
        Engine carEngine = carPartsFactory.createEngine();
        Tires carTires = carPartsFactory.createTires();

        System.out.println("Car setup: " + carEngine.getEngineType() + " and " + carTires.getTireType());

        // Create bike parts using BikePartsFactory
        VehicleFactory bikePartsFactory = new BikeFactory();
        Engine bikeEngine = bikePartsFactory.createEngine();
        Tires bikeTires = bikePartsFactory.createTires();

        System.out.println("Bike setup: " + bikeEngine.getEngineType() + " and " + bikeTires.getTireType());
    }
}

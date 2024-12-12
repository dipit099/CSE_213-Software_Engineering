public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.createVehicle("car");  // using "string type thing"
        vehicle.drive();  // Output: Driving a car!

        vehicle = VehicleFactory.createVehicle("bike");
        vehicle.drive();  // Output: Riding a bike!
    }
}

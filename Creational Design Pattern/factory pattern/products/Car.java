public class Car implements Vehicle {
    Car(){
        System.out.println("Car created!");
    }
    @Override
    public void drive() {
        System.out.println("Driving a car!");
    }
}

public class Bike implements Vehicle {
    Bike(){
        System.out.println("Bike created!");
    }
    @Override
    public void drive() {
        System.out.println("Riding a bike!");
    }
}

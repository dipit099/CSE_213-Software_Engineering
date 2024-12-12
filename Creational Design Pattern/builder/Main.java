import builder.BikeBuilder;
import builder.CarBuilder;
import builder.Director;
import product.Vehicle;

public class Main {
    public static void main(String[] args) {
        // Use Director to construct a standard Car

        //builder and DIRECTOR both lagbe !!
        CarBuilder carBuilder = new CarBuilder();
        Director director = new Director();
        Vehicle car = director.constructVehicle(carBuilder);
        System.out.println(car); // Outputs: Vehicle with Standard Engine engine, 4 wheels, color: Black

          }
}

package builder;

import product.Vehicle;
import refactoring_guru.builder.example.builders.Builder;

public class Director {

    public Vehicle constructVehicle(Builder builder) {
        return builder
                .buildEngine("Standard Engine")
                .buildWheels(4)
                .buildColor("Black")
                .getVehicle(); /* getvehicle() assembles the parts and creates the final product */
    }

}

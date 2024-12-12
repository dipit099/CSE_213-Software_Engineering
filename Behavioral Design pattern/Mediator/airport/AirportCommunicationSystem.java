package airport;

// Step 2: Implement the Concrete Mediator class (ControlTower)
import java.util.ArrayList;
import java.util.List;

// Step 1: Create the Mediator interface
interface Mediator {
    void registerAirplane(Airplane airplane);

    void sendMessage(String message, Airplane sender);
}

class ControlTower implements Mediator {
    private List<Airplane> airplanes;

    public ControlTower() {
        airplanes = new ArrayList<>();
    }

    @Override
    public void registerAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }

    @Override
    public void sendMessage(String message, Airplane sender) {
        message = sender.name + " says: " + message;
        for (Airplane airplane : airplanes) {
            if (airplane != sender) { // Don't send the message back to the sender

                airplane.receiveMessage(message);
            }
        }
    }
}

// Step 3: Create the Abstract Colleague class (Airplane)
abstract class Airplane {
    protected Mediator controlTower;
    protected String name;

    public Airplane(Mediator controlTower, String name) {
        this.controlTower = controlTower;
        this.name = name;
    }

    public abstract void sendMessage(String message);

    public void receiveMessage(String message) {
        System.out.println(name + " received message: [[ " + message + " ]]");
    }
}

// Step 4: Implement Concrete Colleague classes (Specific Airplanes)
class Boeing737 extends Airplane {
    public Boeing737(Mediator controlTower, String name) {
        super(controlTower, name);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + " is sending message: " + message);
        controlTower.sendMessage(message, this);
    }
}

class AirbusA320 extends Airplane {
    public AirbusA320(Mediator controlTower, String name) {
        super(controlTower, name);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + " is sending message: " + message);
        controlTower.sendMessage(message, this);
    }
}

// Step 5: Demonstrate the Mediator Pattern
public class AirportCommunicationSystem {
    public static void main(String[] args) {
        // Create the mediator (ControlTower)
        ControlTower controlTower = new ControlTower();

        // Create airplanes and register them with the control tower
        Airplane boeing737 = new Boeing737(controlTower, "Boeing 737");
        Airplane airbusA320 = new AirbusA320(controlTower, "Airbus A320");
        Airplane airbusA380 = new AirbusA320(controlTower, "Airbus A380");
        Airplane boeing747 = new Boeing737(controlTower, "Boeing 747");

        controlTower.registerAirplane(boeing737);
        controlTower.registerAirplane(airbusA320);
        controlTower.registerAirplane(airbusA380);
        controlTower.registerAirplane(boeing747);

        // Airplanes communicate through the control tower
        boeing737.sendMessage("Requesting permission to land.");
        System.out.println();
        airbusA320.sendMessage("Requesting permission to take off.");
    }
}

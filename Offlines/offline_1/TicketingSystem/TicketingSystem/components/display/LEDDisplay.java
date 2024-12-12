package TicketingSystem.components.display;

public class LEDDisplay implements Display {
    public LEDDisplay() {
        System.out.println("LED Display has been added to the system.");
    }
    @Override
    public void showDisplay() {
        System.out.println("LED Display");
    }
    

}

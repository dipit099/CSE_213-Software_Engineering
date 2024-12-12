package TicketingSystem.components.display;


public class LCDDisplay implements Display {
    public LCDDisplay() {
        System.out.println("LCD Display has been added to the system.");
    }
    @Override
    public void showDisplay() {
        System.out.println("LCD Display");
    }
    
}

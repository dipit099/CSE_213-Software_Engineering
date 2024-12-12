package TicketingSystem.components.display;

public class OLEDDisplay implements Display {
    public OLEDDisplay() {
        System.out.println("OLED Display has been added to the system.");
    }
    @Override
    public void showDisplay() {
        System.out.println("OLED Display");
    }
    

    
}
package TicketingSystem.components.controller;


public class ExternalController implements Controller {

    public ExternalController() {
        System.out.println("External controller has been added to the system.");
    }

    @Override
    // In Java, when you implement a method from an interface, the method must have
    // the same visibility as defined in the interface.
    public void showController() {
        System.out.println("External controller");
    }

}

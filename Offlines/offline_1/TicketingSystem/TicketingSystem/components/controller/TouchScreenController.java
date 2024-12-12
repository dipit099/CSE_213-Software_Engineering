package TicketingSystem.components.controller;

public class TouchScreenController implements Controller {

    public TouchScreenController() {
        System.out.println("Touch screen controller has been added to the system.");
    }

    @Override
    public void showController() {
        System.out.println("Touch screen controller");
    }

}


 // PossibleState.java
interface PossibleState {
    void pressOnButton(Television tvContext);
    void pressOffButton(Television tvContext);
    void pressMuteButton(Television tvContext);
}



// OnState.java
class OnState implements PossibleState {
    @Override
    public void pressOnButton(Television tvContext) {
        System.out.println("TV is already ON.");
    }

    @Override
    public void pressOffButton(Television tvContext) {
        System.out.println("Turning the TV OFF...");
        tvContext.setCurrentState(new OffState());
    }

    @Override
    public void pressMuteButton(Television tvContext) {
        System.out.println("Muting the TV...");
        tvContext.setCurrentState(new MuteState());
    }
}

// OffState.java
class OffState implements PossibleState {
    @Override
    public void pressOnButton(Television tvContext) {
        System.out.println("Turning the TV ON...");
        tvContext.setCurrentState(new OnState());
    }

    @Override
    public void pressOffButton(Television tvContext) {
        System.out.println("TV is already OFF.");
    }

    @Override
    public void pressMuteButton(Television tvContext) {
        System.out.println("TV is OFF. Mute button has no effect.");
    }
}
// MuteState.java
class MuteState implements PossibleState {
    @Override
    public void pressOnButton(Television tvContext) {
        System.out.println("TV is already ON but in Mute mode.");
    }

    @Override
    public void pressOffButton(Television tvContext) {
        System.out.println("Turning the TV OFF from Mute mode...");
        tvContext.setCurrentState(new OffState());
    }

    @Override
    public void pressMuteButton(Television tvContext) {
        System.out.println("Unmuting the TV...");
        tvContext.setCurrentState(new OnState());
    }
}



// Television.java
class Television {
    private PossibleState currentState;

    public Television() {
        // Initial state is OffState
        currentState = new OffState();
    }

    public void setCurrentState(PossibleState state) {
        currentState = state;
    }

    public void pressOnButton() {
        currentState.pressOnButton(this);
    }

    public void pressOffButton() {
        currentState.pressOffButton(this);
    }

    public void pressMuteButton() {
        currentState.pressMuteButton(this);
    }
}

// StatePatternDemo.java
public class StatePatternDemo {
    public static void main(String[] args) {
        Television tv = new Television();

        // Initial state is OffState
        tv.pressOnButton();  // Turn ON the TV
        tv.pressMuteButton(); // Mute the TV
        tv.pressOnButton();  // Try to turn ON again (no effect)
        tv.pressOffButton(); // Turn OFF the TV
        tv.pressMuteButton(); // Try to mute while OFF (no effect)
    }
}


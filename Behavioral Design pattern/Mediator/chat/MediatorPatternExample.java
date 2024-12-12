package chat;
// Mediator Interface

import java.util.HashMap;
import java.util.Map;

interface Mediator {
    void sendMessage(String message, String recipientId, Person sender);

    void addPerson(Person person);
}

// Concrete Mediator
class ChatMediator implements Mediator {
    private Map<String, Person> persons = new HashMap<>(); // ei map e sob person store hbe!!!!!!!!!!!!

    @Override
    public void addPerson(Person person) {
        persons.put(person.getiIdName(), person);
    }

    @Override
    public void sendMessage(String message, String recipientId, Person sender) {
        if (persons.containsKey(recipientId)) { // SYNTAX CHECK...containsKey() method is used to check whether a
                                                // particular key is being mapped into the map or not.
            Person recipient = persons.get(recipientId); // retrieve the value of the key
            recipient.receiveMessage(message, sender);
        } else {
            System.out.println("Recipient not found!");
        }
    }
}

// Person Class
abstract class Person {
    protected Mediator mediator;
    protected String id;

    public Person(Mediator mediator, String id) {
        this.mediator = mediator;
        this.id = id;
    }

    public String getiIdName() {
        return id;
    }

    public abstract void sendMessage(String message, String recipientId);

    public abstract void receiveMessage(String message, Person sender);
}

// Concrete Person
class User extends Person {
    public User(Mediator mediator, String id) {
        super(mediator, id);
    }

    @Override
    public void sendMessage(String message, String recipientId) {
        System.out.println(this.id + " sends: " + message + " to " + recipientId);
        mediator.sendMessage(message, recipientId, this);
    }

    @Override
    public void receiveMessage(String message, Person sender) {
        System.out.println(this.id + " received: " + message + " from " + sender.getiIdName());
    }
}

// Main Class to Demonstrate
public class MediatorPatternExample {
    public static void main(String[] args) {
        Mediator chatMediator = new ChatMediator();

        Person user1 = new User(chatMediator, "Dipit");
        Person user2 = new User(chatMediator, "Mahdi");
        Person user3 = new User(chatMediator, "Raihan");

        chatMediator.addPerson(user1);
        chatMediator.addPerson(user2);
        chatMediator.addPerson(user3);

        user1.sendMessage("Hello, Mahdi!", "Mahdi"); // Sends message to User2
        user2.sendMessage("Hi, Dipit!", "Dipit"); // Sends message back to User1
        user3.sendMessage("Hello, everyone!", "Dipit"); // Sends message to User1
    }
}

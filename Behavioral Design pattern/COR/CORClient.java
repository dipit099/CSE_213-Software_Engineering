// Message.java

class Message {
    public String text;

    public Message(String msg) {
        text = msg;
    }
}

// Handler.java (Interface)
interface Handler {
    void handleMessage(Message message);

    void nextErrorHandler(Handler nextHandler);
}

// FaxErrorHandler.java
class FaxErrorHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void nextErrorHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleMessage(Message message) {  // FULL CYLCE E PASSS KRTE HY
        if (message.text.contains("fax")) {
            // Error message contains both 'fax' and 'email'
            if (message.text.contains("email")) {
                System.out.println("-FaxErrorHandler fixed the fax issue: " + message.text);
                System.out.println("--Now EmailErrorHandler needs to cross verify it.");
                if (nextHandler != null) {
                    nextHandler.handleMessage(message);
                }
            }
            // It's a fax error only
            else {
                System.out.println("FaxErrorHandler processed the issue: " + message.text);
            }
        }
        // Neither a fax issue nor an email issue
        else {
            if (nextHandler != null) {
                nextHandler.handleMessage(message);
            }
        }
    }
}

// EmailErrorHandler.java
class EmailErrorHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void nextErrorHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleMessage(Message message) {
        if (message.text.contains("email")) {
            // Error message contains both 'email' and 'fax'
            if (message.text.contains("fax")) {
                System.out.println("-EmailErrorHandler fixed the email issue: " + message.text);
                System.out.println("--Now FaxErrorHandler needs to cross verify it.");
                if (nextHandler != null) {
                    nextHandler.handleMessage(message); // fax handler bole keno unknown handler e pathalam !?
                }
            }
            // It's an email error only
            else {
                System.out.println("EmailErrorHandler processed the issue: " + message.text);
            }
        }
        // Neither a fax issue nor an email issue
        else {
            if (nextHandler != null) {
                nextHandler.handleMessage(message);
            }
        }
    }
}

// UnknownErrorHandler.java
class UnknownErrorHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void nextErrorHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleMessage(Message message) {
        if (!message.text.contains("fax") && !message.text.contains("email")) {
            System.out.println("UnknownErrorHandler processed the issue: " + message.text);
        } else {
            if (nextHandler != null) {
                nextHandler.handleMessage(message);
                System.out.println("All checked and resolved!");
            }
        }
    }
}

// Client.java
public class CORClient {
    public static void main(String[] args) {
        System.out.println("***Chain of Responsibility Pattern Demo***\n");

        // Objects of the chain
        Handler faxHandler = new FaxErrorHandler();
        Handler emailHandler = new EmailErrorHandler();
        Handler unknownHandler = new UnknownErrorHandler();

        // Forming the chain: FaxErrorHandler -> EmailErrorHandler ->
        // UnknownErrorHandler
        faxHandler.nextErrorHandler(emailHandler);
        emailHandler.nextErrorHandler(unknownHandler);
        unknownHandler.nextErrorHandler(null); // End of chain!!!!!!!!!!!!!!!!!!!!

        // Different error messages
        Message msg1 = new Message("The fax is going slow.");
        Message msg2 = new Message("The emails are not reaching destinations.");
        Message msg3 = new Message("Sometimes the BCC field is disabled in emails.");
        Message msg4 = new Message("The fax is not reaching destinations.");
        Message msg5 = new Message("Neither email nor fax is working properly.");
        Message msg6 = new Message("Users cannot login into the system.");

        // Handling different types of errors
        System.out.println("Handling different types of errors:");
        faxHandler.handleMessage(msg1); // faxHandler is the rootHandler
        System.out.println();

        faxHandler.handleMessage(msg2);
        System.out.println();

        faxHandler.handleMessage(msg3);
        System.out.println();

        faxHandler.handleMessage(msg4);
        System.out.println();

        faxHandler.handleMessage(msg5);
        System.out.println();

        faxHandler.handleMessage(msg6);
        System.out.println();
    }
}

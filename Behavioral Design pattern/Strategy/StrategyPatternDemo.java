// PaymentStrategy.java (Strategy Interface)
interface PaymentStrategy {
    void pay(int amount);
}

// CreditCardPayment.java (Concrete Strategy)
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;  // EI PART TA E different arki for stategies of  Strategy pattern

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card with number: " + cardNumber);
    }
}

// PayPalPayment.java (Concrete Strategy)
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal with email: " + email);
    }
}

// BitcoinPayment.java (Concrete Strategy)
class BitcoinPayment implements PaymentStrategy {
    private String walletAddress;

    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Bitcoin with wallet address: " + walletAddress);
    }
}

// PaymentContext.java (Context Class)
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(int amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment strategy set!");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}

// StrategyPatternDemo.java
public class StrategyPatternDemo {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Paying with Credit Card
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        context.pay(100);

        // Paying with PayPal
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.pay(200);

        // Paying with Bitcoin
        context.setPaymentStrategy(new BitcoinPayment("1A2B3C4D5E6F"));
        context.pay(300);
    }
}

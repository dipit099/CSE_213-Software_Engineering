public class Creditfactory implements Paymentfactory {
    @Override
    public Payment createPayment() {
        return new Credit();
    }

}
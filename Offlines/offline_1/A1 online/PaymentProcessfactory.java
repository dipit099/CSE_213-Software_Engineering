public class PaymentProcessfactory {
    public Paymentfactory processpayment(int value){
        if(value ==  1){
            return new Creditfactory();
        }
        return null;
        
    }
    
}

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> packageMap = new HashMap<>();
        packageMap.put(1, "credit");
        System.out.println();
        System.out.println("choose");
        System.out.println(" ");
        int value = sc.nextInt();

        PaymentProcessfactory paymentProcessfactory = new PaymentProcessfactory();
        Paymentfactory paymentfactory = paymentProcessfactory.processpayment(value);

        Payment payment = paymentfactory.createPayment();
        payment.process();
        sc.close();

    }

}
package BankService;
import BankService.factory.*;
import BankService.account.Account;
import BankService.loan.Loan;

public class Main {
    public static void main(String[] args) {
        //client        

        // regular account
        BankServiceFactory factory = new RegularServiceFactory();  // creates regular service factory
        Account regularAccount = factory.createAccount();
        Loan regularLoan = factory.createLoan();
        System.out.println("Principal: 1000tk, Year: 2");
        System.out.println();
        // Interest now
        System.out.println("Regular Account Interest: " + regularAccount.calculateInterest(1000,2));
        System.out.println("Regular Loan Interest: " + regularLoan.calculateInterest(1000,2));

        // premium account
        factory = new PremiumServiceFactory();
        Account premiumAccount = factory.createAccount();
        Loan premiumLoan = factory.createLoan();
        // Interest now
        System.out.println("Premium Account Interest: " + premiumAccount.calculateInterest(1000,2));
        System.out.println("Premium Loan Interest: " + premiumLoan.calculateInterest(1000,2));

        // VIP account
        factory = new VIPServiceFactory();
        Account vipAccount = factory.createAccount();
        Loan vipLoan = factory.createLoan();
        // Interest now
        System.out.println("VIP Account Interest: " + vipAccount.calculateInterest(1000,2));
        System.out.println("VIP Loan Interest: " + vipLoan.calculateInterest(1000,2));
        


        
    }
    
}
